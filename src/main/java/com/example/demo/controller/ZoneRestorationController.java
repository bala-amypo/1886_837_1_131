package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restorations")
@Tag(name = "Zone Restorations")
public class ZoneRestorationController {

    private final ZoneRestorationServiceImpl service;

    public ZoneRestorationController(ZoneRestorationServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ZoneRestorationRecord restore(@RequestBody ZoneRestorationRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public ZoneRestorationRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<ZoneRestorationRecord> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
