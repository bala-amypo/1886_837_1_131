package com.example.demo.controller;

import com.example.demo.service.LoadSheddingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }

    @PostMapping("/trigger/{forecastId}")
    public void trigger(@PathVariable Long forecastId) {
        service.triggerLoadShedding(forecastId);
    }
}
