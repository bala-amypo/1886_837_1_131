package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

    DemandReading save(DemandReading reading);

    List<DemandReading> getReadingsForZone(Long zoneId);

    DemandReading getLatestReading(Long zoneId);

    // 🔴 THIS METHOD MUST BE IMPLEMENTED
    List<DemandReading> getRecentReadings(Long zoneId, int limit);
}
