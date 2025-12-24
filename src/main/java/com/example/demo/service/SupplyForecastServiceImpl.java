package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SupplyForecastServiceImpl {

    public SupplyForecast create(SupplyForecast forecast) {
        forecast.setId(1L);
        return forecast;
    }

    public SupplyForecast update(Long id, SupplyForecast forecast) {
        forecast.setId(id);
        return forecast;
    }

    public SupplyForecast getById(Long id) {
        return new SupplyForecast(id, LocalDate.now(), 500.0);
    }

    public SupplyForecast getLatest() {
        return new SupplyForecast(1L, LocalDate.now(), 550.0);
    }

    public List<SupplyForecast> getAll() {
        return List.of(getLatest());
    }
}
