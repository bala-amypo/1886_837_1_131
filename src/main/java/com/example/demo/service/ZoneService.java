package com.example.demo.service.impl;

import com.example.demo.entity.Zone;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ZoneService {

    public Zone save(Zone zone) {
        return zone;
    }

    public Zone getById(Long id) {
        return Zone.builder().id(id).build();
    }

    public List<Zone> getAll() {
        return new ArrayList<>();
    }
}
