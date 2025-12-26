package com.example.demo.service;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingService {

    DemandReading createReading(DemandReading r);

    List<DemandReading> getReadingsForZone(Long zoneId);

    DemandReading getLatestReading(Long zoneId);

    // 🔹 REQUIRED BY COMPILER
    DemandReading getLatestByZone(Long zoneId);

    List<DemandReading> getRecentReadings(Long zoneId, int limit);
}
