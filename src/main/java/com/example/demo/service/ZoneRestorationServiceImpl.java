package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    @Autowired
    private ZoneRestorationRecordRepository repository;

    @Override
    public List<ZoneRestorationRecord> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public ZoneRestorationRecord getRecordById(Long id) {
        Optional<ZoneRestorationRecord> record = repository.findById(id);
        return record.orElse(null);
    }

    @Override
    public ZoneRestorationRecord saveRecord(Long zoneId, String status) {
        ZoneRestorationRecord record = new ZoneRestorationRecord();
        record.setZoneId(zoneId);
        record.setTime(LocalDateTime.now());
        record.setStatus(status != null ? status : "PENDING");
        return repository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ZoneRestorationRecord updateStatus(Long id, String status) {
        Optional<ZoneRestorationRecord> optionalRecord = repository.findById(id);
        if (optionalRecord.isPresent()) {
            ZoneRestorationRecord record = optionalRecord.get();
            record.setStatus(status);
            return repository.save(record);
        }
        return null;
    }
}
