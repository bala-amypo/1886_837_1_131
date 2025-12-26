package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.ZoneRestorationService;

import java.util.List;

public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRecordRepository repo;
    private final LoadSheddingEventRepository eventRepo;
    private final ZoneRepository zoneRepo;

    public ZoneRestorationServiceImpl(
            ZoneRestorationRecordRepository repo,
            LoadSheddingEventRepository eventRepo,
            ZoneRepository zoneRepo
    ) {
        this.repo = repo;
        this.eventRepo = eventRepo;
        this.zoneRepo = zoneRepo;
    }

    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord r) {
        LoadSheddingEvent ev = eventRepo.findById(r.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        zoneRepo.findById(r.getZone().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        if (!r.getRestoredAt().isAfter(ev.getEventStart()))
            throw new BadRequestException("after event start");

        return repo.save(r);
    }

    public ZoneRestorationRecord getRecordById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return repo.findByZoneIdOrderByRestoredAtDesc(zoneId);
    }
}
