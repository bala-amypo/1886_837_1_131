package com.example.demo.serviceimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import com.example.demo.service.DemandReadingService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;

    public DemandReadingServiceImpl(DemandReadingRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<DemandReading> getByZone(Long zoneId) {
        return repo.findAll()
                .stream()
                .filter(r -> r.getZone().getId().equals(zoneId))
                .sorted(Comparator.comparing(DemandReading::getRecordedAt).reversed())
                .collect(Collectors.toList());
    }
}
