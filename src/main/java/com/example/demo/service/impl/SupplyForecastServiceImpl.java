package com.example.demo.serviceimpl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.SupplyForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    private final SupplyForecastRepository repository;

    public SupplyForecastServiceImpl(SupplyForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplyForecast createForecast(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast updateForecast(Long id, SupplyForecast forecast) {
        SupplyForecast existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setAvailableSupplyMW(forecast.getAvailableSupplyMW());
        existing.setForecastStart(forecast.getForecastStart());
        existing.setForecastEnd(forecast.getForecastEnd());

        return repository.save(existing);
    }

    @Override
    public SupplyForecast getLatestForecast() {
        List<SupplyForecast> forecasts = repository.findAll();
        if (forecasts.isEmpty()) {
            return null;
        }
        return forecasts.get(forecasts.size() - 1);
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repository.findAll();
    }
}
