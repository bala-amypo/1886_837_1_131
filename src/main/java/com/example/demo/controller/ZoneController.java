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
    public Zone create(@RequestBody Zone z) {
        return service.create(z);
    }

    @GetMapping
    public List<Zone> all() {
        return service.getAll();
    }
}
