package com.example.demo.repository.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemorySupplyForecastRepository implements SupplyForecastRepository {

    private final Map<Long, SupplyForecast> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    @Override
    public SupplyForecast save(SupplyForecast forecast) {
        if (forecast.getId() == null) {
            forecast.setId(idGen.incrementAndGet());
        }
        store.put(forecast.getId(), forecast);
        return forecast;
    }

    @Override
    public Optional<SupplyForecast> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<SupplyForecast> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<SupplyForecast> findFirstByOrderByGeneratedAtDesc() {
        return store.values().stream()
                .max(Comparator.comparing(SupplyForecast::getGeneratedAt));
    }
}
