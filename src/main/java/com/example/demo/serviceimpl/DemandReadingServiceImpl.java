package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;

    public DemandReadingServiceImpl(DemandReadingRepository repo) {
        this.repo = repo;
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
        return repo.findFirstByZone_IdOrderByRecordedAtDesc(zoneId)
                .orElse(null);
    }
}
