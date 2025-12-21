package com.example.demo.controller;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.service.SupplyForecastServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply-forecasts")
@Tag(name = "Supply Forecasts")
public class SupplyForecastController {

    private final SupplyForecastServiceImpl service;

    public SupplyForecastController(SupplyForecastServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public SupplyForecast create(@RequestBody SupplyForecast forecast) {
        return service.create(forecast);
    }

    @PutMapping("/{id}")
    public SupplyForecast update(@PathVariable Long id, @RequestBody SupplyForecast forecast) {
        return service.update(id, forecast);
    }

    @GetMapping("/{id}")
    public SupplyForecast getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/latest")
    public SupplyForecast getLatest() {
        return service.getLatest();
    }

    @GetMapping
    public List<SupplyForecast> getAll() {
        return service.getAll();
    }
}
