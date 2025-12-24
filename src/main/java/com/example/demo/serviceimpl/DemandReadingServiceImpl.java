package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS MANDATORY
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;

    public DemandReadingServiceImpl(DemandReadingRepository repo) {
        this.repo = repo;
    }

    @Override
    public DemandReading save(DemandReading reading) {
        return repo.save(reading);
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {
        return repo.findFirstByZoneIdOrderByRecordedAtDesc(zoneId).orElse(null);
    }

    @Override
    public List<DemandReading> getAll() {
        return repo.findAll();
    }
}
