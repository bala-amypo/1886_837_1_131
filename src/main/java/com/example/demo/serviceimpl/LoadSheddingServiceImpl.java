package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final SupplyForecastRepository forecastRepo;
    private final ZoneRepository zoneRepo;
    private final DemandReadingRepository readingRepo;
    private final LoadSheddingEventRepository eventRepo;

    public LoadSheddingServiceImpl(SupplyForecastRepository forecastRepo,
                                   ZoneRepository zoneRepo,
                                   DemandReadingRepository readingRepo,
                                   LoadSheddingEventRepository eventRepo) {
        this.forecastRepo = forecastRepo;
        this.zoneRepo = zoneRepo;
        this.readingRepo = readingRepo;
        this.eventRepo = eventRepo;
    }

    // ✅ 1. EXISTS IN INTERFACE
    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {
        SupplyForecast forecast = forecastRepo.findById(forecastId)
                .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

        List<Zone> zones = zoneRepo.findByActiveTrueOrderByPriorityLevelAsc();
        if (zones.isEmpty()) {
            throw new BadRequestException("No overload");
        }

        for (Zone zone : zones) {
            DemandReading reading =
                    readingRepo.findFirstByZoneIdOrderByRecordedAtDesc(zone.getId())
                            .orElse(null);

            if (reading != null &&
                reading.getDemandMW() > forecast.getAvailableSupplyMW()) {

                LoadSheddingEvent event = LoadSheddingEvent.builder()
                        .zone(zone)
                        .eventStart(Instant.now())
                        .triggeredByForecastId(forecastId)
                        .expectedDemandReductionMW(reading.getDemandMW())
                        .build();

                return eventRepo.save(event);
            }
        }

        throw new BadRequestException("No overload");
    }

    // ✅ 2. EXISTS IN INTERFACE
    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    // ✅ 3. EXISTS IN INTERFACE
    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepo.findByZoneIdOrderByEventStartDesc(zoneId);
    }

    // ✅ 4. EXISTS IN INTERFACE
    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepo.findAll();
    }
}
