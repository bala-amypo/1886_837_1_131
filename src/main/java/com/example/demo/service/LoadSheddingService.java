package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;
import java.util.List;

public interface LoadSheddingService {

    LoadSheddingEvent triggerLoadShedding(Long zoneId);

    List<LoadSheddingEvent> getAllEvents();

    List<LoadSheddingEvent> getEventsForZone(Long zoneId);

    LoadSheddingEvent endLoadShedding(Long eventId);
}
