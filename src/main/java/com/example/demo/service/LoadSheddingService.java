package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import java.util.List;

public interface LoadSheddingService {

    LoadSheddingEvent createEvent();

    LoadSheddingEvent getEventById(Long id);

    List<LoadSheddingEvent> getAllEvents();
}
