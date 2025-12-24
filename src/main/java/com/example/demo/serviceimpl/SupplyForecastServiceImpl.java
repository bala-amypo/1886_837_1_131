package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import java.time.Instant;
import java.util.*;

public class SupplyForecastServiceImpl {

    private final SupplyForecastRepository repo;

    public SupplyForecastServiceImpl(SupplyForecastRepository r) {
        repo = r;
    }

    public SupplyForecast createForecast(SupplyForecast s) {
        if (s.getAvailableSupplyMW() < 0)
            throw new BadRequestException(">= 0");

        if (s.getForecastStart().isAfter(s.getForecastEnd()))
            throw new BadRequestException("range");

        s.setGeneratedAt(Instant.now());
        return repo.save(s);
    }

    public SupplyForecast updateForecast(Long id, SupplyForecast s) {
        SupplyForecast e = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

        e.setAvailableSupplyMW(s.getAvailableSupplyMW());
        e.setForecastStart(s.getForecastStart());
        e.setForecastEnd(s.getForecastEnd());
        return repo.save(e);
    }

    public SupplyForecast getLatestForecast() {
        return repo.findFirstByOrderByGeneratedAtDesc()
                .orElseThrow(() -> new ResourceNotFoundException("No forecasts"));
    }

    public List<SupplyForecast> getAllForecasts() {
        return repo.findAll();
    }
}
