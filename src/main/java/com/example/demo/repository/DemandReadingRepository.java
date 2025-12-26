package com.example.demo.repository;

import com.example.demo.entity.DemandReading;
import java.util.List;

public interface DemandReadingRepository {
    DemandReading save(DemandReading r);
    List<DemandReading> findAll();
}
