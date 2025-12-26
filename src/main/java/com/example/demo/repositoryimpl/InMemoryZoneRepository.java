package com.example.demo.repositoryimpl;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryZoneRepository implements ZoneRepository {

    private final Map<Long, Zone> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    @Override
    public Zone save(Zone zone) {
        if (zone.getId() == null) {
            zone.setId(idGen.incrementAndGet());
        }
        store.put(zone.getId(), zone);
        return zone;
    }

    @Override
    public List<Zone> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Zone> findActiveZones() {
        return store.values().stream()
                .filter(Zone::isActive)
                .collect(Collectors.toList());
    }
}
