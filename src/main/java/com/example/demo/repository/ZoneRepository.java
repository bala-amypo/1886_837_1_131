package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ZoneRepository {
    Optional<Zone> findById(Long id);
    Optional<Zone> findByZoneName(String name);
    List<Zone> findAll();
    List<Zone> findByActiveTrueOrderByPriorityLevelAsc();
    Zone save(Zone zone);
}
