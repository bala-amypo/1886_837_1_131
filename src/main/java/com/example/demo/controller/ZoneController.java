package com.example.demo.controller;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneRepository repo;

    public ZoneController(ZoneRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Zone create(@RequestBody Zone z) {
        return repo.save(z);
    }

    @GetMapping
    public List<Zone> all() {
        return repo.findAll();
    }
}
