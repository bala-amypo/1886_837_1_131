package com.example.demo.repository.impl;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemorySupplyForecastRepository implements SupplyForecastRepository {

    private final Map<Long, SupplyForecast> store = new HashMap<>();
    private long seq = 1;

    @Override
    public SupplyForecast save(SupplyForecast f) {
        if (f.getId() == null) {
            f.setId(seq++);
        }
        store.put(f.getId(), f);
        return f;
    }

    @Override
    public Optional<SupplyForecast> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<SupplyForecast> findFirstByOrderByGeneratedAtDesc() {
        return store.values().stream()
                .max(Comparator.comparing(SupplyForecast::getGeneratedAt));
    }

    @Override
    public List<SupplyForecast> findAll() {
        return new ArrayList<>(store.values());
    }
}
