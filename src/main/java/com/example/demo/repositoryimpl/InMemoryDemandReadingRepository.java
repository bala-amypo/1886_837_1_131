package com.example.demo.repository.impl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryDemandReadingRepository implements DemandReadingRepository {

    private final Map<Long, DemandReading> store = new HashMap<>();
    private long seq = 1;

    @Override
    public DemandReading save(DemandReading r) {
        if (r.getId() == null) {
            r.setId(seq++);
        }
        store.put(r.getId(), r);
        return r;
    }

    @Override
    public Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId) {
        return store.values().stream()
                .filter(r -> r.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(DemandReading::getRecordedAt).reversed())
                .findFirst();
    }

    @Override
    public List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId) {
        return store.values().stream()
                .filter(r -> r.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(DemandReading::getRecordedAt).reversed())
                .collect(Collectors.toList());
    }
}
