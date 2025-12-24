package com.example.demo.service;

import com.example.demo.entity.Zone;
import java.util.List;

public interface ZoneService {

    Zone createZone(Zone zone);

    List<Zone> getAllZones();

    Zone updateZone(Long id, Zone zone);

    void deactivateZone(Long id);
}
