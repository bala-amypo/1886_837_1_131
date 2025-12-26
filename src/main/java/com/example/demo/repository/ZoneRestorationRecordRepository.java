package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ZoneRestorationRecordRepository {
    ZoneRestorationRecord save(ZoneRestorationRecord r);
    Optional<ZoneRestorationRecord> findById(Long id);
    List<ZoneRestorationRecord> findByZoneIdOrderByRestoredAtDesc(Long id);
}
