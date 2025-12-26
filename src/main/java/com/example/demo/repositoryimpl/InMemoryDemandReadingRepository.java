package com.example.demo.repository.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryDemandReadingRepository implements DemandReadingRepository {

    private final Map<Long, DemandReading> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    @Override
    public DemandReading save(DemandReading reading) {
        if (reading.getId() == null) {
            reading.setId(idGen.incrementAndGet());
        }
        store.put(reading.getId(), reading);
        return reading;
    }

    @Override
    public Optional<DemandReading> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<DemandReading> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId) {
        return store.values().stream()
                .filter(r -> r.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(DemandReading::getRecordedAt).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId) {
        return findByZoneIdOrderByRecordedAtDesc(zoneId).stream().findFirst();
    }
}
