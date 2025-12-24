package com.example.demo.controller;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneServiceImpl service;

    public ZoneController(ZoneServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Zone create(@RequestBody Zone zone) {
        return service.createZone(zone);
    }

    @GetMapping("/{id}")
    public Zone get(@PathVariable Long id) {
        return service.getZoneById(id);
    }

    @GetMapping
    public List<Zone> getAll() {
        return service.getAllZones();
    }

    @PutMapping("/{id}/deactivate")
    public Zone deactivate(@PathVariable Long id) {
        return service.deactivateZone(id);
    }
}
