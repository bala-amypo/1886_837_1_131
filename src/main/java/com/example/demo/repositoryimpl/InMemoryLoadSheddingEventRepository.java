package com.example.demo.repository.impl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryLoadSheddingEventRepository implements LoadSheddingEventRepository {

    private final Map<Long, LoadSheddingEvent> store = new HashMap<>();
    private long seq = 1;

    @Override
    public LoadSheddingEvent save(LoadSheddingEvent e) {
        if (e.getId() == null) {
            e.setId(seq++);
        }
        store.put(e.getId(), e);
        return e;
    }

    @Override
    public Optional<LoadSheddingEvent> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<LoadSheddingEvent> findByZoneIdOrderByEventStartDesc(Long zoneId) {
        return store.values().stream()
                .filter(e -> e.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(LoadSheddingEvent::getEventStart).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<LoadSheddingEvent> findAll() {
        return new ArrayList<>(store.values());
    }
}
