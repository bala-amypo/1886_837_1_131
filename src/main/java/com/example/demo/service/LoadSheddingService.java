package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import java.util.List;

public interface LoadSheddingService {

    LoadSheddingEvent createEvent(LoadSheddingEvent event);

    List<LoadSheddingEvent> getAllEvents();

    LoadSheddingEvent getEventById(Long id);
}
