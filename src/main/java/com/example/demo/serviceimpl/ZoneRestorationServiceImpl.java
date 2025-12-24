package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRepository repo;
    private final ZoneRepository zoneRepo;
    private final LoadSheddingRepository eventRepo;

    public ZoneRestorationServiceImpl(
            ZoneRestorationRepository repo,
            ZoneRepository zoneRepo,
            LoadSheddingRepository eventRepo) {
        this.repo = repo;
        this.zoneRepo = zoneRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public List<ZoneRestorationRecord> getAllRecords() {
        return repo.findAll();
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public ZoneRestorationRecord saveRecord(Long zoneId, String time) {
        Zone z = zoneRepo.findById(zoneId).orElseThrow();
        LoadSheddingEvent ev = eventRepo.findAll().get(0);

        ZoneRestorationRecord r = new ZoneRestorationRecord();
        r.setZone(z);
        r.setEvent(ev);
        r.setRestoredAt(Instant.parse(time));
        return repo.save(r);
    }

    @Override
    public ZoneRestorationRecord updateStatus(Long id, String time) {
        ZoneRestorationRecord r = repo.findById(id).orElseThrow();
        r.setRestoredAt(Instant.parse(time));
        return repo.save(r);
    }

    @Override
    public void deleteRecord(Long id) {
        repo.deleteById(id);
    }
}
