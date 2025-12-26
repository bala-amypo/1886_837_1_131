package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationService {

    ZoneRestorationRecord createRecord(ZoneRestorationRecord record);

    ZoneRestorationRecord getRecordById(Long id);

    List<ZoneRestorationRecord> getRecordsForZone(Long zoneId);

    void deleteRecord(Long id);
}
