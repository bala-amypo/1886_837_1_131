package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingRepository eventRepository;
    private final ZoneRepository zoneRepository;
    private final DemandReadingRepository demandRepository;
    private final SupplyForecastRepository forecastRepository;

    public LoadSheddingServiceImpl(
            LoadSheddingRepository eventRepository,
            ZoneRepository zoneRepository,
            DemandReadingRepository demandRepository,
            SupplyForecastRepository forecastRepository) {
        this.eventRepository = eventRepository;
        this.zoneRepository = zoneRepository;
        this.demandRepository = demandRepository;
        this.forecastRepository = forecastRepository;
    }

    @Override
    public LoadSheddingEvent generateEvent(Long zoneId) {

        Zone z = zoneRepository.findById(zoneId).orElseThrow();
        DemandReading reading = demandRepository.findAll().get(0);
        SupplyForecast forecast = forecastRepository.findAll().get(0);

        Long shedMW = Math.max(
                0,
                reading.getDemandMW() - forecast.getAvailableSupplyMW()
        );

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setZone(z);
        event.setShedMW(shedMW);
        event.setEventStart(Instant.now());

        return eventRepository.save(event);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}
