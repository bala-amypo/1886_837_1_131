package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone-restorations")
public class ZoneRestorationController {

    private final ZoneRestorationService service;

    public ZoneRestorationController(ZoneRestorationService service) {
        this.service = service;
    }

    
    @PostMapping("/{eventId}")
    public ZoneRestorationRecord restoreZone(@PathVariable Long eventId) {
        return service.createRecord(eventId);
    }

    @GetMapping("/{id}")
    public ZoneRestorationRecord getById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<ZoneRestorationRecord> getByZone(@PathVariable Long zoneId) {
        return service.getRecordsForZone(zoneId);
    }

    @GetMapping
    public List<ZoneRestorationRecord> getAll() {
        return service.getAllRecords();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
