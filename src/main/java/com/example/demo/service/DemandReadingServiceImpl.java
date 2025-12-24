package com.example.demo.service.impl;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DemandReadingService {

    public DemandReading save(DemandReading reading) {
        return reading;
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
