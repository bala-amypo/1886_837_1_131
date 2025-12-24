package com.example.demo.controller;

import com.example.demo.service.LoadSheddingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }
}
