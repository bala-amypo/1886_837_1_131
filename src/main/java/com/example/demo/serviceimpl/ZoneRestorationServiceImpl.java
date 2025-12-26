package com.example.demo.service.impl;

import com.example.demo.entity.Zone;
import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRecordRepository recordRepo;
    private final ZoneRepository zoneRepo;

    public ZoneRestorationServiceImpl(
            ZoneRestorationRecordRepository recordRepo,
            ZoneRepository zoneRepo) {
        this.recordRepo = recordRepo;
        this.zoneRepo = zoneRepo;
    }

    @Override
    public ZoneRestorationRecord createRecord(ZoneRestorationRecord record) {

        Zone zone = zoneRepo.findById(record.getZoneId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        zone.setActive(true);
        zoneRepo.save(zone);

        record.setRestoredAt(Instant.now());
        return recordRepo.save(record);
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return recordRepo.findByZoneId(zoneId);
    }

    @Override
    public void deleteRecord(Long id) {
        if (!recordRepo.existsById(id)) {
            throw new ResourceNotFoundException("Record not found");
        }
        recordRepo.deleteById(id);
    }
}
