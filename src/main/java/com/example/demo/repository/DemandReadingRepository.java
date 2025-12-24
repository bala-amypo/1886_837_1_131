package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {

    // Latest reading for a zone
    DemandReading findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);

    // All readings for a zone
    List<DemandReading> findByZoneId(Long zoneId);
}
