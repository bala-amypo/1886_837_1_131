package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingEventRepository repo;

    public LoadSheddingServiceImpl(LoadSheddingEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return repo.findByZoneId(zoneId);
    }
}
