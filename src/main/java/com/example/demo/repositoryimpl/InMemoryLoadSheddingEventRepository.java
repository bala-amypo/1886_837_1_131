package com.example.demo.repositoryimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryLoadSheddingEventRepository implements LoadSheddingEventRepository {

    private final Map<Long, LoadSheddingEvent> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public LoadSheddingEvent save(LoadSheddingEvent event) {
        if (event.getId() == null) {
            event.setId(idGen.getAndIncrement());
        }
        store.put(event.getId(), event);
        return event;
    }

    @Override
    public Optional<LoadSheddingEvent> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // ✅ REQUIRED
    @Override
    public List<LoadSheddingEvent> findAll() {
        return new ArrayList<>(store.values());
    }
}
