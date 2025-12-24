package com.example.demo.serviceimpl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository repo;

    public SupplyForecastServiceImpl(SupplyForecastRepository repo) {
        this.repo = repo;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast s) {
        if (s.getAvailableSupplyMW() < 0)
            throw new BadRequestException("Supply must be >= 0");

        if (s.getForecastEnd().isBefore(s.getForecastStart()))
            throw new BadRequestException("Invalid supply forecast range");

        s.setGeneratedAt(Instant.now());
        return repo.save(s);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast updated) {
        SupplyForecast existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

        existing.setAvailableSupplyMW(updated.getAvailableSupplyMW());
        existing.setForecastStart(updated.getForecastStart());
        existing.setForecastEnd(updated.getForecastEnd());
        return repo.save(existing);
    }

    @Override
    public SupplyForecast getLatestForecast() {
        return repo.findFirstByOrderByGeneratedAtDesc()
                .orElseThrow(() -> new ResourceNotFoundException("No forecasts"));
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repo.findAll();
    }
}
