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

    /**
     * Trigger load shedding for a given forecast ID
     * NOTE: Service method returns void (as per interface & tests)
     */
    @PostMapping("/trigger/{forecastId}")
    public void triggerLoadShedding(@PathVariable Long forecastId) {
        service.triggerLoadShedding(forecastId);
    }
}
