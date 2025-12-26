package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restorations")
public class ZoneRestorationController {

    private final ZoneRestorationService service;

    public ZoneRestorationController(ZoneRestorationService service) {
        this.service = service;
    }

    /**
     * Create a restoration record
     */
    @PostMapping
    public ZoneRestorationRecord create(
            @RequestBody ZoneRestorationRecord record) {
        return service.createRecord(record);
    }

    /**
     * Get restoration record by ID
     */
    @GetMapping("/{id}")
    public ZoneRestorationRecord getById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    /**
     * Get all restoration records for a zone
     */
    @GetMapping("/zone/{zoneId}")
    public List<ZoneRestorationRecord> getByZone(@PathVariable Long zoneId) {
        return service.getRecordsForZone(zoneId);
    }

    /**
     * Delete a restoration record
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
