package com.example.demo.repository;

import com.example.demo.entity.LoadSheddingEvent;
import java.util.List;
import java.util.Optional;

public interface LoadSheddingEventRepository {

    LoadSheddingEvent save(LoadSheddingEvent event);

    Optional<LoadSheddingEvent> findById(Long id);

    List<LoadSheddingEvent> findAll();

    // 🔑 ADD THIS (FIX)
    List<LoadSheddingEvent> findByZoneId(Long zoneId);
}
