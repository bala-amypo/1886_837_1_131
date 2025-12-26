package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS WAS MISSING
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repository;

    public DemandReadingServiceImpl(DemandReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public DemandReading save(DemandReading reading) {
        return repository.save(reading);
    }

    @Override
    public List<DemandReading> getReadingsForZone(Long zoneId) {
        return repository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public DemandReading getLatestReading(Long zoneId) {
        List<DemandReading> readings =
                repository.findByZoneIdOrderByRecordedAtDesc(zoneId);

        return readings.isEmpty() ? null : readings.get(0);
    }
}
