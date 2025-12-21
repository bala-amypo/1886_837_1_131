package com.example.demo.service;

import com.example.demo.entity.Zone;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl {

    private final ZoneRepository repository;

    public ZoneServiceImpl(ZoneRepository repository) {
        this.repository = repository;
    }

    public Zone createZone(Zone zone) {
        return repository.save(zone);
    }

    public Zone updateZone(Long id, Zone zone) {
        Zone existing = getZoneById(id);
        existing.setZoneName(zone.getZoneName());
        return repository.save(existing);
    }

    public Zone getZoneById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
    }

    public List<Zone> getAllZones() {
        return repository.findAll();
    }

    public Zone deactivateZone(Long id) {
        Zone zone = getZoneById(id);
        zone.setActive(false);
        return repository.save(zone);
    }
}
