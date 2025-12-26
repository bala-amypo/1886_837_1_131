package com.example.demo.repositoryimpl;

import com.example.demo.entity.DemandReading;
import com.example.demo.repository.DemandReadingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDemandReadingRepository implements DemandReadingRepository {

    private final List<DemandReading> store = new ArrayList<>();

    @Override
    public DemandReading save(DemandReading r) {
        store.add(r);
        return r;
    }

    @Override
    public List<DemandReading> findAll() {
        return store;
    }
}
