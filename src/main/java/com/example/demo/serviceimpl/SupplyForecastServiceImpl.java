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
    public SupplyForecast save(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public List<SupplyForecast> getAllForecasts() {
        return repository.findAll();
    }

    @Override
    public SupplyForecast getForecastById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
