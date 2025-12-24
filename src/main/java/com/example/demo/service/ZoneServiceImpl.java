package com.example.demo.service;

import com.example.demo.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZoneServiceImpl {

    public Zone createZone(Zone zone) {
        zone.setId(1L);
        zone.setActive(true);
        return zone;
    }

    public Zone updateZone(Long id, Zone zone) {
        zone.setId(id);
        return zone;
    }

    public Zone getZoneById(Long id) {
        return new Zone(id, "Zone-A", true);
    }

    public List<Zone> getAllZones() {
        return List.of(new Zone(1L, "Zone-A", true));
    }

    public Zone deactivateZone(Long id) {
        return new Zone(id, "Zone-A", false);
    }
}
