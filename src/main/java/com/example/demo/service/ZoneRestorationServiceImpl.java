package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneRestorationServiceImpl {

    private final ZoneRestorationRecordRepository repository;

    public ZoneRestorationServiceImpl(ZoneRestorationRecordRepository repository) {
        this.repository = repository;
    }

    public ZoneRestorationRecord create(ZoneRestorationRecord record) {
        return repository.save(record);
    }

    public ZoneRestorationRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restoration not found"));
    }

    public List<ZoneRestorationRecord> getByZone(Long zoneId) {
        return repository.findByZoneIdOrderByRestoredAtDesc(zoneId);
    }
}
