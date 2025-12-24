package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyForecastServiceImpl {

    public SupplyForecast create(SupplyForecast forecast) {
        return forecast;
    }

    public SupplyForecast update(Long id, SupplyForecast forecast) {
        return forecast;
    }

    public SupplyForecast getById(Long id) {
        return new SupplyForecast();
    }

    public SupplyForecast getLatest() {
        return new SupplyForecast();
    }

    public List<SupplyForecast> getAll() {
        return List.of();
    }
}
