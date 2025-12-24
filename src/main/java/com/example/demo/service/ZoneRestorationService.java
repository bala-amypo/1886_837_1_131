package com.example.demo.service;

public interface ZoneRestorationService {

    void saveRecord(Long zoneId, String time);

    void updateStatus(Long recordId, String time);

    void deleteRecord(Long id);
}
