package com.example.demo.controller;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.service.LoadSheddingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loadshedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }

    @PostMapping("/trigger/{zoneId}")
    public ResponseEntity<LoadSheddingEvent> triggerLoadShedding(
            @PathVariable Long zoneId) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.triggerLoadShedding(zoneId));
    }
}
