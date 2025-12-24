package com.example.demo.controller;

import com.example.demo.model.DemandReading;
import com.example.demo.service.DemandReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/readings")
public class DemandReadingController {

    @Autowired
    private DemandReadingService service;

    @GetMapping
    public List<DemandReading> getAllReadings() {
        return service.getAllReadings();
    }

    @GetMapping("/{id}")
    public DemandReading getReadingById(@PathVariable Long id) {
        return service.getReadingById(id);
    }

    @PostMapping
    public DemandReading saveReading(@RequestBody DemandReading reading) {
        return service.saveReading(reading);
    }

    @DeleteMapping("/{id}")
    public void deleteReading(@PathVariable Long id) {
        service.deleteReading(id);
    }
}
