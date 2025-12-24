package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ZoneRestorationServiceImpl {

    public ZoneRestorationRecord save(ZoneRestorationRecord r) {
        return r;
    }

    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
