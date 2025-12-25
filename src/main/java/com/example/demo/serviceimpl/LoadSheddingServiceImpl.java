package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.service.LoadSheddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingEventRepository repo;

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long zoneId) {

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZoneId(zoneId);
        event.setEventStart(Instant.now());
        event.setStatus("STARTED"); // REQUIRED by test

        return repo.save(event);
    }
}
