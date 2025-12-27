package com.example.demo.serviceimpl;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.ZoneService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service   // ✅ THIS WAS MISSING
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Zone createZone(Zone zone) {
        zone.setActive(true);
        zone.setCreatedAt(Instant.now());
        return zoneRepository.save(zone);
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Long id) {
        return zoneRepository.findById(id).orElse(null);
    }

    @Override
    public Zone updateZone(Long id, Zone zone) {
        Zone existing = getZoneById(id);
        if (existing == null) return null;

        existing.setZoneName(zone.getZoneName());
        existing.setPriorityLevel(zone.getPriorityLevel());
        existing.setPopulation(zone.getPopulation());
        existing.setUpdatedAt(Instant.now());

        return zoneRepository.save(existing);
    }

    @Override
    public void deactivateZone(Long id) {
        Zone zone = getZoneById(id);
        if (zone != null) {
            zone.setActive(false);
            zoneRepository.save(zone);
        }
    }
}
