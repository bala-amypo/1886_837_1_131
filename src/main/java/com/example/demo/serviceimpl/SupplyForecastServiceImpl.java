package com.example.demo.serviceimpl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository repository;

    public SupplyForecastServiceImpl(SupplyForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        forecast.setGeneratedAt(Instant.now());
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        SupplyForecast existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forecast not found"));

        existing.setAvailableSupplyMW(forecast.getAvailableSupplyMW());
        existing.setForecastStart(forecast.getForecastStart());
        existing.setForecastEnd(forecast.getForecastEnd());
        existing.setGeneratedAt(Instant.now());

        return repository.save(existing);
    }

    @Override
    public SupplyForecast getLatestForecast() {
        return repository.findFirstByOrderByGeneratedAtDesc()
                .orElseThrow(() -> new RuntimeException("No forecast found"));
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repository.findAll();
    }
}
