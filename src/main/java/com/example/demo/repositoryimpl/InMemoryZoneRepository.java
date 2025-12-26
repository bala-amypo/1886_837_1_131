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
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public Zone save(Zone zone) {
        if (zone.getId() == null) {
            zone.setId(idGen.getAndIncrement());
        }
        store.put(zone.getId(), zone);
        return zone;
    }

    @Override
    public Optional<Zone> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // ✅ REQUIRED
    @Override
    public List<Zone> findAll() {
        return new ArrayList<>(store.values());
    }

    // ✅ REQUIRED
    @Override
    public Optional<Zone> findByZoneName(String zoneName) {
        return store.values().stream()
                .filter(z -> z.getZoneName().equalsIgnoreCase(zoneName))
                .findFirst();
    }

    @Override
    public List<Zone> findByActiveTrueOrderByPriorityLevelAsc() {
        return store.values().stream()
                .filter(Zone::isActive)
                .sorted(Comparator.comparingInt(Zone::getPriorityLevel))
                .collect(Collectors.toList());
    }
}
