package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.Zone;
import com.example.demo.repository.LoadSheddingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingRepository repo;
    private final ZoneRepository zoneRepo;

    public LoadSheddingServiceImpl(
            LoadSheddingRepository repo,
            ZoneRepository zoneRepo) {
        this.repo = repo;
        this.zoneRepo = zoneRepo;
    }

    @Override
    public LoadSheddingEvent createEvent() {
        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setStartTime(Instant.now());
        return repo.save(event);
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long zoneId) {

        Zone zone = zoneRepo.findById(zoneId).orElse(null);
        if (zone == null) return null;

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZone(zone);
        event.setStartTime(Instant.now());

        return repo.save(event);
    }
}
