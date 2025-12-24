package com.example.demo.service.impl;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ZoneRestorationService {

    public ZoneRestorationRecord save(ZoneRestorationRecord record) {
        return record;
    }

    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
