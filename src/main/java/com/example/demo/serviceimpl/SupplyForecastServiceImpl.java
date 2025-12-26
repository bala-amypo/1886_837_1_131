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
        forecast.setId(id);
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast getLatestForecast() {
        return repository.findAll()
                .stream()
                .reduce((first, second) -> second)
                .orElse(null);
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repository.findAll();
    }
}
