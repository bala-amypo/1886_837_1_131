package com.example.demo.service.impl;

import com.example.demo.entity.LoadSheddingEvent;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoadSheddingService {

    public LoadSheddingEvent save(LoadSheddingEvent event) {
        return event;
    }

    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
