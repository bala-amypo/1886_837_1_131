package com.example.demo.service;

import com.example.demo.entity.LoadShedding;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl {

    // 🔥 ADD THIS METHOD
    public LoadShedding create(LoadShedding shedding) {
        shedding.setId(1L);
        shedding.setActive(true);
        return shedding;
    }

    public LoadShedding trigger(Long zoneId) {
        return new LoadShedding(2L, zoneId, true);
    }

    public LoadShedding getById(Long id) {
        return new LoadShedding(id, 1L, true);
    }

    public List<LoadShedding> getByZone(Long zoneId) {
        return List.of(new LoadShedding(3L, zoneId, true));
    }

    public List<LoadShedding> getAll() {
        return getByZone(1L);
    }
}
