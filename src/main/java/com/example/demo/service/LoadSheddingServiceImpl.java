package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoadSheddingEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl {

    private final LoadSheddingEventRepository repository;

    public LoadSheddingServiceImpl(LoadSheddingEventRepository repository) {
        this.repository = repository;
    }

    public LoadSheddingEvent trigger(Long forecastId) {
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setTriggeredByForecastId(forecastId);
        return repository.save(event);
    }

    public LoadSheddingEvent getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public List<LoadSheddingEvent> getByZone(Long zoneId) {
        return repository.findByZoneIdOrderByEventStartDesc(zoneId);
    }

    public List<LoadSheddingEvent> getAll() {
        return repository.findAll();
    }
}
