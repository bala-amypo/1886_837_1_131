package com.example.demo.repositoryimpl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryZoneRestorationRecordRepository
        implements ZoneRestorationRecordRepository {

    private final Map<Long, ZoneRestorationRecord> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public ZoneRestorationRecord save(ZoneRestorationRecord record) {
        if (record.getId() == null) {
            record.setId(idGen.getAndIncrement());
        }
        store.put(record.getId(), record);
        return record;
    }

    @Override
    public Optional<ZoneRestorationRecord> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // ✅ REQUIRED (ORDERED)
    @Override
    public List<ZoneRestorationRecord> findByZoneIdOrderByRestoredAtDesc(Long zoneId) {
        return store.values().stream()
                .filter(r -> Objects.equals(r.getZoneId(), zoneId))
                .sorted(Comparator.comparing(ZoneRestorationRecord::getRestoredAt).reversed())
                .collect(Collectors.toList());
    }

    // ✅ REQUIRED
    @Override
    public List<ZoneRestorationRecord> findAll() {
        return new ArrayList<>(store.values());
    }

    // ✅ REQUIRED
    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
