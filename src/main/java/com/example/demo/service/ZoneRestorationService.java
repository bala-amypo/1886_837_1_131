package com.example.demo.service;

import com.example.demo.entity.ZoneRestorationRecord;
import java.util.List;

public interface ZoneRestorationService {

    ZoneRestorationRecord restoreZone(ZoneRestorationRecord record);

    List<ZoneRestorationRecord> getAllRecords();

    void deleteRecord(Long id);
}
