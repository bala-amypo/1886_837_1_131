package com.example.demo.controller;

import com.example.demo.service.DemandReadingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demand")
public class DemandReadingController {

    private final DemandReadingService service;

    public DemandReadingController(DemandReadingService service) {
        this.service = service;
    }
}
