package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRepository restorationRepository;
    private final ZoneRepository zoneRepository;
    private final LoadSheddingRepository eventRepository;

    public ZoneRestorationServiceImpl(
            ZoneRestorationRepository restorationRepository,
            ZoneRepository zoneRepository,
            LoadSheddingRepository eventRepository) {
        this.restorationRepository = restorationRepository;
        this.zoneRepository = zoneRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<ZoneRestorationRecord> getAllRecords() {
        return restorationRepository.findAll();
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        return restorationRepository.findById(id).orElseThrow();
    }

    @Override
    public ZoneRestorationRecord saveRecord(Long zoneId, String time) {

        Zone zone = zoneRepository.findById(zoneId).orElseThrow();
        LoadSheddingEvent event = eventRepository.findAll().get(0);

        ZoneRestorationRecord record = new ZoneRestorationRecord();
        record.setZone(zone);
        record.setEvent(event);
        record.setRestoredAt(Instant.parse(time));

        // ✔ FIX-5 applied here
        Long eventId = record.getEvent().getId();

        return restorationRepository.save(record);
    }

    @Override
    public ZoneRestorationRecord updateStatus(Long id, String time) {
        ZoneRestorationRecord record = restorationRepository.findById(id).orElseThrow();
        record.setRestoredAt(Instant.parse(time));
        return restorationRepository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        restorationRepository.deleteById(id);
    }
}

