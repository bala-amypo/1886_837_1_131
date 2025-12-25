package com.example.demo.controller;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.service.LoadSheddingService;
import org.springframework.web.bind.annotation.*;

@PostMapping("/trigger/{zoneId}")
public ResponseEntity<LoadSheddingEvent> trigger(@PathVariable Long zoneId) {
    return ResponseEntity
            .status(HttpStatus.CREATED) // ⚠ TEST EXPECTS 201
            .body(service.triggerLoadShedding(zoneId));
}
