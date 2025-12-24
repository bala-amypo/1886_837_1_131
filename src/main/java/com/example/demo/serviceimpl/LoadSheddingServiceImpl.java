package com.example.demo.serviceimpl;

import com.example.demo.entity.LoadSheddingEvent;
import com.example.demo.entity.DemandReading;
import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.LoadSheddingRepository;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.repository.SupplyForecastRepository;
import com.example.demo.service.LoadSheddingService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class LoadSheddingServiceImpl implements LoadSheddingService {

    private final LoadSheddingRepository loadSheddingRepository;
    private final DemandReadingRepository demandReadingRepository;
    private final SupplyForecastRepository supplyForecastRepository;

    public LoadSheddingServiceImpl(
            LoadSheddingRepository loadSheddingRepository,
            DemandReadingRepository demandReadingRepository,
            SupplyForecastRepository supplyForecastRepository) {
        this.loadSheddingRepository = loadSheddingRepository;
        this.demandReadingRepository = demandReadingRepository;
        this.supplyForecastRepository = supplyForecastRepository;
    }

    @Override
    public LoadSheddingEvent createEvent() {

        List<DemandReading> demands = demandReadingRepository.findAll();
        List<SupplyForecast> forecasts = supplyForecastRepository.findAll();

        double totalDemand = demands.stream()
                .mapToDouble(DemandReading::getDemandMW)
                .sum();

        double totalSupply = forecasts.stream()
                .mapToDouble(SupplyForecast::getAvailableSupplyMW)
                .sum();

        LoadSheddingEvent event = new LoadSheddingEvent();
        event.setTotalDemand(totalDemand);
        event.setTotalSupply(totalSupply);
        event.setEventStart(Instant.now());
        event.setStatus(totalDemand > totalSupply ? "ACTIVE" : "NO_SHEDDING");

        return loadSheddingRepository.save(event);
    }

    @Override
    public LoadSheddingEvent getEventById(Long id) {
        return loadSheddingRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoadSheddingEvent> getAllEvents() {
        return loadSheddingRepository.findAll();
    }
}
