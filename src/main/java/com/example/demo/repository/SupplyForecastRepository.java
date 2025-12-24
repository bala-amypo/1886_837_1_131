package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;

@Service
public class SupplyForecastServiceImpl {

    @Autowired
    private SupplyForecastRepository supplyForecastRepository;

    // CREATE
    public SupplyForecast saveSupplyForecast(SupplyForecast supplyForecast) {
        return supplyForecastRepository.save(supplyForecast);
    }

    // READ ALL
    public List<SupplyForecast> getAllSupplyForecasts() {
        return supplyForecastRepository.findAll();
    }

    // READ BY ID
    public SupplyForecast getSupplyForecastById(Long id) {
        return supplyForecastRepository.findById(id).orElse(null);
    }

    // UPDATE
    public SupplyForecast updateSupplyForecast(Long id, SupplyForecast updatedForecast) {
        SupplyForecast existing = supplyForecastRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setForecastDate(updatedForecast.getForecastDate());
            existing.setExpectedSupply(updatedForecast.getExpectedSupply());
            return supplyForecastRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public void deleteSupplyForecast(Long id) {
        supplyForecastRepository.deleteById(id);
    }
}
