package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplyForecastRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl {

    private final SupplyForecastRepository repository;

    public SupplyForecastServiceImpl(SupplyForecastRepository repository) {
        this.repository = repository;
    }

    public SupplyForecast create(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    public SupplyForecast update(Long id, SupplyForecast forecast) {
        SupplyForecast existing = getById(id);
        existing.setAvailableSupplyMW(forecast.getAvailableSupplyMW());
        existing.setForecastStart(forecast.getForecastStart());
        existing.setForecastEnd(forecast.getForecastEnd());
        return repository.save(existing);
    }

    public SupplyForecast getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));
    }

    public SupplyForecast getLatest() {
        return repository.findFirstByOrderByGeneratedAtDesc();
    }

    public List<SupplyForecast> getAll() {
        return repository.findAll();
    }
}
