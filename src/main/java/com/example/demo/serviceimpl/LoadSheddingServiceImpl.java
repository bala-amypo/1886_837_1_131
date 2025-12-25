package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.Zone;
import com.example.demo.repository.LoadSheddingRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

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
        return repo.save(new LoadSheddingEvent());
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long zoneId) {

        Zone zone = zoneRepo.findById(zoneId).orElse(null);
        if (zone == null) return null;

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZone(zone);                 
        event.setEventStatus("SHEDDING");    

        return repo.save(event);
    }
}
