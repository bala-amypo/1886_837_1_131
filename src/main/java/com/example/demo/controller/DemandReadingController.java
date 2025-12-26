package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand-readings")
public class DemandReadingController {

    private final DemandReadingService service;

    public DemandReadingController(DemandReadingService service) {
        this.service = service;
    }

    /**
     * Create a new demand reading
     */
    @PostMapping
    public DemandReading create(@RequestBody DemandReading reading) {
        return service.save(reading); // ✅ FIXED
    }

    /**
     * Get all readings for a zone
     */
    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return service.getReadingsForZone(zoneId);
    }

    /**
     * Get latest reading for a zone
     */
    @GetMapping("/zone/{zoneId}/latest")
    public DemandReading getLatest(@PathVariable Long zoneId) {
        return service.getLatestReading(zoneId);
    }

    /**
     * Get recent N readings for a zone
     */
    @GetMapping("/zone/{zoneId}/recent/{limit}")
    public List<DemandReading> getRecent(
            @PathVariable Long zoneId,
            @PathVariable int limit) {
        return service.getRecentReadings(zoneId, limit);
    }
}
