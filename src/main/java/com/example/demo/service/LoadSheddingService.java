package com.example.demo.service;

import com.example.demo.entity.LoadSheddingEvent;

public interface LoadSheddingService {

    LoadSheddingEvent createEvent();

    LoadSheddingEvent triggerLoadShedding(Long zoneId);
}
