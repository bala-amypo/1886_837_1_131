package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface DemandReadingRepository {
    DemandReading save(DemandReading r);
    Optional<DemandReading> findFirstByZoneIdOrderByRecordedAtDesc(Long id);
    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long id);
}
