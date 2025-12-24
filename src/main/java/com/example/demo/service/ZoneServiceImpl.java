package com.example.demo.service;

import com.example.demo.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl {

    public Zone create(Zone zone) {
        return zone;
    }

    public Zone getById(Long id) {
        return new Zone();
    }

    public List<Zone> getAll() {
        return List.of();
    }

    public Zone update(Long id, Zone zone) {
        return zone;
    }
}
