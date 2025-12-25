package com.example.demo.serviceimpl;

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

    private final SupplyForecastRepository supplyRepo;
    private final ZoneRepository zoneRepo;
    private final DemandReadingRepository demandRepo;
    private final LoadSheddingEventRepository eventRepo;

    // ⚠️ CONSTRUCTOR ORDER MUST MATCH TESTCASE
    public LoadSheddingServiceImpl(
            SupplyForecastRepository supplyRepo,
            ZoneRepository zoneRepo,
            DemandReadingRepository demandRepo,
            LoadSheddingEventRepository eventRepo
    ) {
        this.supplyRepo = supplyRepo;
        this.zoneRepo = zoneRepo;
        this.demandRepo = demandRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long forecastId) {

        SupplyForecast forecast = supplyRepo.findById(forecastId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double supply = forecast.getAvailableSupplyMW();

        List<DemandReading> readings = demandRepo.findAll();
        double totalDemand = readings.stream()
                .mapToDouble(DemandReading::getDemandMW)
                .sum();

        if (totalDemand <= supply) {
            throw new BadRequestException("No overload");
        }

        List<Zone> zones = zoneRepo.findByActiveTrueOrderByPriorityLevelAsc();

        for (Zone zone : zones) {

            DemandReading latest = demandRepo
                    .findFirstByZoneIdOrderByRecordedAtDesc(zone.getId())
                    .orElse(null);

            if (latest == null) continue;

            LoadSheddingEvent event = LoadSheddingEvent.builder()
                    .zone(zone)
                    .eventStart(Instant.now())
                    .reason("AUTO_LOAD_SHEDDING")
                    .triggeredByForecastId(forecastId)
                    .expectedDemandReductionMW(latest.getDemandMW())
                    .build();

            return eventRepo.save(event);
        }

        throw new BadRequestException("No overload");
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return eventRepo.findByZoneIdOrderByEventStartDesc(zoneId);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepo.findAll();
    }
}
