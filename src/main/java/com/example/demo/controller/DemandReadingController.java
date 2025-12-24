package com.example.demo.controller;

import com.example.demo.entity.DemandReading;
import com.example.demo.service.DemandReadingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demand")
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

    @GetMapping("/latest/{zoneId}")
    public DemandReading getLatest(@PathVariable Long zoneId) {
        return service.getLatest(zoneId);
    }

    @GetMapping("/zone/{zoneId}")
    public List<DemandReading> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
