package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoadSheddingServiceImpl {

    public LoadSheddingEvent save(LoadSheddingEvent e) {
        return e;
    }

    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return new ArrayList<>();
    }
}
