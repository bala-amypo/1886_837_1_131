package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository readingRepo;

    public DemandReadingServiceImpl(DemandReadingRepository readingRepo) {
        this.readingRepo = readingRepo;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return readingRepo.save(reading);
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {
        return readingRepo.findAll().stream()
                .filter(r -> r.getZoneId().equals(zoneId))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        return readingRepo.findAll().stream()
                .filter(r -> r.getZoneId().equals(zoneId))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
