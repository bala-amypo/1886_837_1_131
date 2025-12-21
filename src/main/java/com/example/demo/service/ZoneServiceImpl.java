package com.example.demo.service;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl {

    private final ZoneRepository repo;

    public ZoneServiceImpl(ZoneRepository repo) {
        this.repo = repo;
    }

    public Zone create(Zone z) {
        return repo.save(z);
    }

    public List<Zone> getAll() {
        return repo.findAll();
    }
}
