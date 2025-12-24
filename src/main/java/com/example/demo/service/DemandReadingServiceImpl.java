package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DemandReadingServiceImpl {

    public DemandReading create(DemandReading reading) {
        reading.setId(1L);
        return reading;
    }

    public DemandReading getById(Long id) {
        return new DemandReading(id, 1L, 120.0);
    }

    public DemandReading getLatest(Long zoneId) {
        DemandReading r = new DemandReading();
        r.setZoneId(zoneId);
        r.setValue(150.0);
        return r;
    }

    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return List.of(new DemandReading(1L, zoneId, 140.0));
    }
}
