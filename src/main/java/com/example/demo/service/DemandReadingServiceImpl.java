package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DemandReadingServiceImpl {

    private final DemandReadingRepository repository;

    public DemandReadingServiceImpl(DemandReadingRepository repository) {
        this.repository = repository;
    }

    public DemandReading create(DemandReading reading) {
        reading.setRecordedAt(LocalDateTime.now()); // ✅ REQUIRED
        return repository.save(reading);
    }

    public DemandReading getLatest(Long zoneId) {
        return repository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return repository.findByZoneId(zoneId);
    }
}
