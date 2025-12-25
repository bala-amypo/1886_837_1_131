package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRecordRepository recordRepo;
    private final LoadSheddingEventRepository eventRepo;
    private final ZoneRepository zoneRepo;

    // ⚠️ ORDER REQUIRED BY TESTCASE
    public ZoneRestorationServiceImpl(
            ZoneRestorationRecordRepository recordRepo,
            LoadSheddingEventRepository eventRepo,
            ZoneRepository zoneRepo
    ) {
        this.recordRepo = recordRepo;
        this.eventRepo = eventRepo;
        this.zoneRepo = zoneRepo;
    }

    @Override
    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord record) {

        LoadSheddingEvent event = eventRepo.findById(record.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (record.getRestoredAt().isBefore(event.getEventStart())) {
            throw new BadRequestException("after event start");
        }

        return recordRepo.save(record);
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return recordRepo.findByZoneIdOrderByRestoredAtDesc(zoneId);
    }
}
