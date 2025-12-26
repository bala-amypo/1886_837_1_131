package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.LoadSheddingEventRepository;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.LoadSheddingService;
import com.example.demo.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final DemandReadingRepository demandReadingRepository;
    private final SupplyForecastRepository supplyForecastRepository;
    private final LoadSheddingEventRepository loadSheddingEventRepository;

    public LoadSheddingServiceImpl(
            DemandReadingRepository demandReadingRepository,
            SupplyForecastRepository supplyForecastRepository,
            LoadSheddingEventRepository loadSheddingEventRepository
    ) {
        this.demandReadingRepository = demandReadingRepository;
        this.supplyForecastRepository = supplyForecastRepository;
        this.loadSheddingEventRepository = loadSheddingEventRepository;
    }

    @Override
    public LoadSheddingEvent triggerLoadShedding(Long zoneId) {

        // get latest demand reading for zone
        DemandReading reading = demandReadingRepository.findAll().stream()
                .filter(r -> r.getZone() != null && r.getZone().getId().equals(zoneId))
                .max(Comparator.comparing(DemandReading::getRecordedAt))
                .orElseThrow(() ->
                        new RuntimeException("No demand reading found for zone " + zoneId));

        // get latest supply forecast
        SupplyForecast forecast = supplyForecastRepository.findAll().stream()
                .max(Comparator.comparing(SupplyForecast::getGeneratedAt))
                .orElseThrow(() ->
                        new RuntimeException("No supply forecast available"));

        double demand = reading.getDemandMW();
        double supply = forecast.getAvailableSupplyMW();

        if (demand <= supply) {
            throw new RuntimeException("Load shedding not required");
        }

        double difference = demand - supply;
        Instant now = DateTimeUtil.now();

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZone(reading.getZone());
        event.setEventStart(now);
        event.setEventEnd(null);
        event.setReason("Demand exceeds supply");
        event.setTriggeredByForecastId(forecast.getId());
        event.setExpectedDemandReductionMW(difference);

        return loadSheddingEventRepository.save(event);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return loadSheddingEventRepository.findAll();
    }

    // 🔑 METHOD NAME FIXED TO MATCH INTERFACE
    @Override
    public List<LoadSheddingEvent> getEventsForZone(Long zoneId) {
        return loadSheddingEventRepository.findAll().stream()
                .filter(e -> e.getZone() != null && e.getZone().getId().equals(zoneId))
                .toList();
    }

    @Override
    public LoadSheddingEvent endLoadShedding(Long eventId) {

        LoadSheddingEvent event = loadSheddingEventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RuntimeException("Load shedding event not found"));

        event.setEventEnd(DateTimeUtil.now());
        return loadSheddingEventRepository.save(event);
    }
}
