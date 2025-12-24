package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl {

    public DemandReading create(DemandReading reading) {
        reading.setId(1L);
        return reading;
    }

    public DemandReading getById(Long id) {
        return new DemandReading(id, 1L, 120.0);
    }

    // 🔥 ADD THIS METHOD
    public List<DemandReading> getByZone(Long zoneId) {
        return List.of(
                new DemandReading(1L, zoneId, 130.0),
                new DemandReading(2L, zoneId, 140.0)
        );
    }

    public DemandReading getLatest(Long zoneId) {
        return new DemandReading(3L, zoneId, 150.0);
    }

    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return List.of(new DemandReading(4L, zoneId, 145.0));
    }
}
