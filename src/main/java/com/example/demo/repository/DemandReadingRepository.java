package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface DemandReadingRepository {
    Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);
    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId);
    DemandReading save(DemandReading r);
}
