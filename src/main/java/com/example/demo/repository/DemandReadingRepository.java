package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DemandReadingRepository
        extends JpaRepository<DemandReading, Long> {

    Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);
}
