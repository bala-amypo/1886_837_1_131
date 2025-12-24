package com.example.demo.controller;

import com.example.demo.service.ZoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneService service;

    public ZoneController(ZoneService service) {
        this.service = service;
    }
}
