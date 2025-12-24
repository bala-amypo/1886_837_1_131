package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
@Tag(name = "Demand Readings")
public class DemandReadingController {

    private final DemandReadingServiceImpl service;

    public DemandReadingController(DemandReadingServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public DemandReading create(@RequestBody DemandReading reading) {
        return service.create(reading);
    }

    @GetMapping("/{id}")
    public DemandReading getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }

    @GetMapping("/zone/{zoneId}/latest")
    public DemandReading getLatest(@PathVariable Long zoneId) {
        return service.getLatest(zoneId);
    }

    @GetMapping("/zone/{zoneId}/recent")
    public List<DemandReading> getRecent(
            @PathVariable Long zoneId,
            @RequestParam(defaultValue = "5") int limit) {
        return service.getRecent(zoneId, limit);
    }
}
