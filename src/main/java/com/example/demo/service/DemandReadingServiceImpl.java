package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandReadingServiceImpl {

    public DemandReading create(DemandReading reading) {
        return reading;
    }

    public DemandReading getLatest(Long zoneId) {
        return DemandReading.builder()
                .zoneId(zoneId)
                .value(120.5)
                .build();
    }

    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return new ArrayList<>();
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
