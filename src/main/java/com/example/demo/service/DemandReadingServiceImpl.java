package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl {

    private final DemandReadingRepository repository;

    public DemandReadingServiceImpl(DemandReadingRepository repository) {
        this.repository = repository;
    }

    public DemandReading create(DemandReading reading) {
        return repository.save(reading);
    }

    public DemandReading getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return repository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    public DemandReading getLatest(Long zoneId) {
        return repository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return repository.findByZoneIdOrderByRecordedAtDesc(zoneId)
                .stream()
                .limit(limit)
                .toList();
    }
}
