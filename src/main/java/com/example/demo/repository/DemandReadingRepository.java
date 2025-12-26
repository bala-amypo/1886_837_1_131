package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import java.util.List;
import java.util.Optional;

public interface DemandReadingRepository {

    DemandReading save(DemandReading reading);

    Optional<DemandReading> findById(Long id);

    List<DemandReading> findAll();

    // 🔑 REQUIRED BY SERVICE
    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId);

    Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);
}
