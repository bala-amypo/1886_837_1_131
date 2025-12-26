package com.example.demo.service.impl;

import com.example.demo.entity.Zone;
import com.example.demo.exception.*;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;

import java.time.Instant;
import java.util.List;

public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository repo;

    public ZoneServiceImpl(ZoneRepository repo) {
        this.repo = repo;
    }

    public Zone createZone(Zone z) {
        if (z.getPriorityLevel() < 1)
            throw new BadRequestException(">= 1");

        if (repo.findByZoneName(z.getZoneName()).isPresent())
            throw new BadRequestException("unique");

        z.setActive(true);
        z.setCreatedAt(Instant.now());
        return repo.save(z);
    }

    public Zone updateZone(Long id, Zone z) {
        Zone ex = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        ex.setZoneName(z.getZoneName());
        ex.setPriorityLevel(z.getPriorityLevel());
        ex.setPopulation(z.getPopulation());
        ex.setUpdatedAt(Instant.now());
        return repo.save(ex);
    }

    public Zone getZoneById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
    }

    public List<Zone> getAllZones() {
        return repo.findAll();
    }

    public void deactivateZone(Long id) {
        Zone z = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
        z.setActive(false);
        repo.save(z);
    }
}
