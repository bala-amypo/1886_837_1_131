package com.example.demo.repository.impl;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryZoneRepository implements ZoneRepository {

    private final Map<Long, Zone> store = new HashMap<>();
    private long seq = 1;

    @Override
    public Optional<Zone> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Zone> findByZoneName(String name) {
        return store.values().stream()
                .filter(z -> z.getZoneName().equals(name))
                .findFirst();
    }

    @Override
    public List<Zone> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Zone> findByActiveTrueOrderByPriorityLevelAsc() {
        return store.values().stream()
                .filter(Zone::getActive)
                .sorted(Comparator.comparing(Zone::getPriorityLevel))
                .collect(Collectors.toList());
    }

    @Override
    public Zone save(Zone z) {
        if (z.getId() == null) {
            z.setId(seq++);
        }
        store.put(z.getId(), z);
        return z;
    }
}
