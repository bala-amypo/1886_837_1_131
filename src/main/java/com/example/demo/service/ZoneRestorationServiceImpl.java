package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZoneRestorationServiceImpl {

    public ZoneRestorationRecord create(ZoneRestorationRecord record) {
        record.setId(1L);
        return record;
    }

    public ZoneRestorationRecord getById(Long id) {
        return new ZoneRestorationRecord(id, 1L);
    }

    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return List.of(new ZoneRestorationRecord(1L, zoneId));
    }
}
