package com.example.demo.controller;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.service.LoadSheddingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load-shedding")
@Tag(name = "Load Shedding")
public class LoadSheddingController {

    private final LoadSheddingServiceImpl service;

    public LoadSheddingController(LoadSheddingServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/trigger/{forecastId}")
    public LoadSheddingEvent trigger(@PathVariable Long forecastId) {
        return service.trigger(forecastId);
    }

    @GetMapping("/{id}")
    public LoadSheddingEvent getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<LoadSheddingEvent> getByZone(@PathVariable Long zoneId) {
        return service.getByZone(zoneId);
    }

    @GetMapping
    public List<LoadSheddingEvent> getAll() {
        return service.getAll();
    }
}
