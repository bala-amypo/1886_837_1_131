package com.example.demo.repository.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryZoneRestorationRecordRepository implements ZoneRestorationRecordRepository {

    private final Map<Long, ZoneRestorationRecord> store = new HashMap<>();
    private long seq = 1;

    @Override
    public ZoneRestorationRecord save(ZoneRestorationRecord r) {
        if (r.getId() == null) {
            r.setId(seq++);
        }
        store.put(r.getId(), r);
        return r;
    }

    @Override
    public Optional<ZoneRestorationRecord> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<ZoneRestorationRecord> findByZoneIdOrderByRestoredAtDesc(Long zoneId) {
        return store.values().stream()
                .filter(r -> r.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(ZoneRestorationRecord::getRestoredAt).reversed())
                .collect(Collectors.toList());
    }
}
