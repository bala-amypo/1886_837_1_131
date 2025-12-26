package com.example.demo.repository.impl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryLoadSheddingEventRepository implements LoadSheddingEventRepository {

    private final Map<Long, LoadSheddingEvent> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    @Override
    public LoadSheddingEvent save(LoadSheddingEvent event) {
        if (event.getId() == null) {
            event.setId(idGen.incrementAndGet());
        }
        store.put(event.getId(), event);
        return event;
    }

    @Override
    public Optional<LoadSheddingEvent> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<LoadSheddingEvent> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<LoadSheddingEvent> findByZoneId(Long zoneId) {
        return store.values().stream()
                .filter(e -> e.getZone().getId().equals(zoneId))
                .collect(Collectors.toList());
    }
}
