package com.example.demo.service;

import com.example.demo.entity.LoadShedding;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadSheddingServiceImpl {

    public LoadShedding create(LoadShedding event) {
        return event;
    }

    public List<LoadShedding> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
