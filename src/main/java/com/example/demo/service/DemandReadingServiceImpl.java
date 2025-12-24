package com.example.demo.service;

import com.example.demo.model.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    @Autowired
    private DemandReadingRepository repository;

    @Override
    public List<DemandReading> getAllReadings() {
        return repository.findAll();
    }

    @Override
    public DemandReading getReadingById(Long id) {
        Optional<DemandReading> reading = repository.findById(id);
        return reading.orElse(null);
    }

    @Override
    public DemandReading saveReading(DemandReading reading) {
        return repository.save(reading);
    }

    @Override
    public void deleteReading(Long id) {
        repository.deleteById(id);
    }
}
