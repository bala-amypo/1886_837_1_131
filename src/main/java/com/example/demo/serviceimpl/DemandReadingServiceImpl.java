package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.DemandReadingService;

import java.time.Instant;
import java.util.List;

public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;
    private final ZoneRepository zoneRepo;

    public DemandReadingServiceImpl(DemandReadingRepository r, ZoneRepository z) {
        this.repo = r;
        this.zoneRepo = z;
    }

    public DemandReading createReading(DemandReading r) {
        Zone z = zoneRepo.findById(r.getZone().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        if (r.getDemandMW() < 0)
            throw new BadRequestException(">= 0");

        if (r.getRecordedAt().isAfter(Instant.now()))
            throw new BadRequestException("future");

        r.setZone(z);
        return repo.save(r);
    }

    public List<DemandReading> getReadingsForZone(Long id) {
        zoneRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
        return repo.findByZoneIdOrderByRecordedAtDesc(id);
    }

    public DemandReading getLatestReading(Long id) {
        return repo.findFirstByZoneIdOrderByRecordedAtDesc(id)
                .orElseThrow(() -> new ResourceNotFoundException("No readings"));
    }

    public List<DemandReading> getRecentReadings(Long id, int limit) {
        zoneRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        List<DemandReading> list = repo.findByZoneIdOrderByRecordedAtDesc(id);
        return list.subList(0, Math.min(limit, list.size()));
    }
     @Override
    public DemandReading getLatestByZone(Long zoneId) {
        return getLatestReading(zoneId);
    }

}

