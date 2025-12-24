package com.example.demo.service;

import com.example.demo.entity.LoadShedding;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl {

    public LoadShedding trigger(Long zoneId) {
        return new LoadShedding();
    }

    public LoadShedding getById(Long id) {
        return new LoadShedding();
    }

    public List<LoadShedding> getAll() {
        return List.of();
    }
}
