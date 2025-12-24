package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneRestorationController {

    @Autowired
    private ZoneRestorationService service;

    @GetMapping
    public List<ZoneRestorationRecord> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public ZoneRestorationRecord getRecordById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @PostMapping
    public ZoneRestorationRecord createRecord(@RequestParam Long zoneId,
                                              @RequestParam(required = false) String status) {
        return service.saveRecord(zoneId, status);
    }

    @PutMapping("/{id}")
    public ZoneRestorationRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
