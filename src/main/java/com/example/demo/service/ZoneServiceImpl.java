package com.example.demo.service;

import com.example.demo.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneServiceImpl {

    public Zone createZone(Zone zone) {
        zone.setActive(true);
        return zone;
    }

    public Zone updateZone(Long id, Zone zone) {
        zone.setId(id);
        return zone;
    }

    public Zone getZoneById(Long id) {
        return Zone.builder()
                .id(id)
                .zoneName("Zone A")
                .active(true)
                .build();
    }

    public List<Zone> getAllZones() {
        return new ArrayList<>();
    }

    public void deactivateZone(Long id) {
        // mock deactivate
    }
}
