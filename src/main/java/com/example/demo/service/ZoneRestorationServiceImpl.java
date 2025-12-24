package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.stereotype.Service;

@Service
public class ZoneRestorationServiceImpl {

    public ZoneRestorationRecord create(ZoneRestorationRecord record) {
        return record;
    }

    public ZoneRestorationRecord getById(Long id) {
        return new ZoneRestorationRecord();
    }
}
