package com.example.demo.controller;

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneService zoneService;   // ✔ FIELD ADDED

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;     // ✔ ASSIGNMENT FIXED
    }

    @PostMapping
    public Zone create(@RequestBody Zone z) {
        return zoneService.createZone(z);
    }

    @GetMapping
    public List<Zone> getAll() {
        return zoneService.getAllZones();
    }

    @GetMapping("/{id}")
    public Zone getOne(@PathVariable Long id) {
        return zoneService.getZoneById(id);
    }

    @PutMapping("/{id}")
    public Zone update(@PathVariable Long id, @RequestBody Zone z) {
        return zoneService.updateZone(id, z);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        zoneService.deleteZone(id);
    }
}
