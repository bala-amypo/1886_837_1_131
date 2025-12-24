package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ZoneRepository {
    Optional<Zone> findByZoneName(String name);
    Optional<Zone> findById(Long id);
    List<Zone> findAll();
    List<Zone> findByActiveTrueOrderByPriorityLevelAsc();
    Zone save(Zone z);
}
