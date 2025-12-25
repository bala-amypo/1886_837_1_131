package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingRepository repo;

    public LoadSheddingServiceImpl(LoadSheddingRepository repo) {
        this.repo = repo;
    }

    @Override
    public LoadSheddingEvent createEvent() {
        LoadSheddingEvent event = new LoadSheddingEvent();
        return repo.save(event);
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long zoneId) {
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZoneId(zoneId);
        event.setStatus("SHEDDING");
        return repo.save(event);
    }
}
