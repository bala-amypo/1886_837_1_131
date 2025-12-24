package com.example.demo.serviceimpl;

import com.example.demo.entity.Zone;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository repo;

    public ZoneServiceImpl(ZoneRepository repo) {
        this.repo = repo;
    }

    @Override
    public Zone createZone(Zone z) {
        z.setCreatedAt(Instant.now());
        z.setActive(true);
        return repo.save(z);
    }

    @Override
    public Zone updateZone(Long id, Zone updated) {
        Zone existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        existing.setZoneName(updated.getZoneName());
        existing.setPriorityLevel(updated.getPriorityLevel());
        existing.setPopulation(updated.getPopulation());
        existing.setActive(updated.getActive());
        existing.setUpdatedAt(Instant.now());

        return repo.save(existing);
    }

    @Override
    public Zone getZoneById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));
    }

    @Override
    public List<Zone> getAllZones() {
        return repo.findAll();
    }

    @Override
    public void deleteZone(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Zone not found");

        repo.deleteById(id);
    }
}
