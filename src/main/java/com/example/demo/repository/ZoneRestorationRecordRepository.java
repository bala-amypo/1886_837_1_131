package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ZoneRestorationRecordRepository {
    Optional<ZoneRestorationRecord> findById(Long id);
    List<ZoneRestorationRecord> findByZoneIdOrderByRestoredAtDesc(Long zoneId);
    ZoneRestorationRecord save(ZoneRestorationRecord r);
}
