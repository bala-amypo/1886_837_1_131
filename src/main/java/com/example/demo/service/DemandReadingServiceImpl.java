package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DemandReadingServiceImpl {

    public DemandReading save(DemandReading d) {
        return d;
    }

    public List<DemandReading> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
