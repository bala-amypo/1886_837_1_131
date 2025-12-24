package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl {

    public ZoneRestorationRecord create(ZoneRestorationRecord record) {
        return record;
    }

    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
