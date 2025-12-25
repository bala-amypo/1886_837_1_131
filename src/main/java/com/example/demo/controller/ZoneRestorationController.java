package com.example.demo.controller;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restoration")
public class ZoneRestorationController {

    private final ZoneRestorationService service;

    public ZoneRestorationController(ZoneRestorationService service) {
        this.service = service;
    }

    @PostMapping
    public ZoneRestorationRecord restore(@RequestBody ZoneRestorationRecord r) {
        return service.restoreZone(r);
    }
}
