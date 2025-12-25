package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.entity.Zone;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;
    private final ZoneRepository zoneRepo;

    public DemandReadingServiceImpl(
            DemandReadingRepository repo,
            ZoneRepository zoneRepo) {
        this.repo = repo;
        this.zoneRepo = zoneRepo;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return repo.save(reading);
    }

    @Override
    public List<DemandReading> getAll() {
        return repo.findAll();
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {

        Zone zone = zoneRepo.findById(zoneId).orElse(null);
        if (zone == null) return null;

        return repo.findFirstByZoneOrderByRecordedAtDesc(zone).orElse(null);
    }
}
