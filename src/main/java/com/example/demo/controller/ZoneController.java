package com.example.demo.controller;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@Tag(name = "Zones")
public class ZoneController {

    private final ZoneServiceImpl service;

    public ZoneController(ZoneServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Zone createZone(@RequestBody Zone zone) {
        return service.createZone(zone);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable Long id, @RequestBody Zone zone) {
        return service.updateZone(id, zone);
    }

    @GetMapping("/{id}")
    public Zone getZone(@PathVariable Long id) {
        return service.getZoneById(id);
    }

    @GetMapping
    public List<Zone> getAllZones() {
        return service.getAllZones();
    }

    @PutMapping("/{id}/deactivate")
    public Zone deactivateZone(@PathVariable Long id) {
        return service.deactivateZone(id);
    }
}
