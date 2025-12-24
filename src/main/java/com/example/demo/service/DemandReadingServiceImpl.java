package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandReadingServiceImpl {

    public DemandReading create(DemandReading reading) {
        return reading;
    }

    public DemandReading getById(Long id) {
        return new DemandReading();
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return List.of();
    }
}
