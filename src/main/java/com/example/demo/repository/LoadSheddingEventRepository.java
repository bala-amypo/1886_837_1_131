package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface LoadSheddingEventRepository {
    LoadSheddingEvent save(LoadSheddingEvent e);
    Optional<LoadSheddingEvent> findById(Long id);
    List<LoadSheddingEvent> findByZoneIdOrderByEventStartDesc(Long id);
    List<LoadSheddingEvent> findAll();
}
