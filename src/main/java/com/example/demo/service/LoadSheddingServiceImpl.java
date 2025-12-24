package com.example.demo.service;

import com.example.demo.entity.LoadShedding;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoadSheddingServiceImpl {

    public LoadShedding trigger(Long zoneId) {
        return new LoadShedding(1L, zoneId, true);
    }

    public LoadShedding getById(Long id) {
        return new LoadShedding(id, 1L, true);
    }

    public List<LoadShedding> getByZone(Long zoneId) {
        return List.of(new LoadShedding(1L, zoneId, true));
    }

    public List<LoadShedding> getAll() {
        return getByZone(1L);
    }
}
