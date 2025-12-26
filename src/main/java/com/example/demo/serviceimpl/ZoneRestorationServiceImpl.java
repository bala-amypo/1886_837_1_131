package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRecordRepository restorationRepo;
    private final LoadSheddingEventRepository eventRepo;

    public ZoneRestorationServiceImpl(
            ZoneRestorationRecordRepository restorationRepo,
            LoadSheddingEventRepository eventRepo) {
        this.restorationRepo = restorationRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public ZoneRestorationRecord restoreZone(Long eventId) {

        LoadSheddingEvent event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        ZoneRestorationRecord record = new ZoneRestorationRecord();
        record.setEventId(eventId);
        record.setZoneId(event.getZoneId());
        record.setRestoredAt(Instant.now());

        return restorationRepo.save(record);
    }

    // ✅ REQUIRED
    @Override
    public List<ZoneRestorationRecord> getRecordsForZone(Long zoneId) {
        return restorationRepo.findByZoneId(zoneId);
    }

    // ✅ FIXED (repository has delete, not deleteById)
    @Override
    public void deleteRecord(Long id) {
        restorationRepo.delete(id);
    }
}
