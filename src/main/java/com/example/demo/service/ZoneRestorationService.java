package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;

import java.util.List;

public interface ZoneRestorationService {

    ZoneRestorationRecord createRecord(Long eventId);

    ZoneRestorationRecord getRecordById(Long id);

    List<ZoneRestorationRecord> getRecordsForZone(Long zoneId);

    List<ZoneRestorationRecord> getAllRecords();

    void deleteRecord(Long id);
}
