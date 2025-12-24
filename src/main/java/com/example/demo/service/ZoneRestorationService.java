package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationService {

    List<ZoneRestorationRecord> getAllRecords();

    ZoneRestorationRecord getRecordById(Long id);

    ZoneRestorationRecord saveRecord(Long zoneId, String time);

    ZoneRestorationRecord updateStatus(Long id, String time);

    void deleteRecord(Long id);
}
