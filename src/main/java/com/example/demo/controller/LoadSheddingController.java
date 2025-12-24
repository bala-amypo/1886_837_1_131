package com.example.demo.controller;

import com.example.demo.entity.LoadShedding;
import com.example.demo.service.LoadSheddingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingServiceImpl service;

    public LoadSheddingController(LoadSheddingServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public LoadShedding create(@RequestBody LoadShedding event) {
        return service.create(event);
    }

    @GetMapping("/{zoneId}")
    public List<LoadShedding> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }
}
