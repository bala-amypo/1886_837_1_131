package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface SupplyForecastService {
    SupplyForecast createForecast(SupplyForecast s);
    SupplyForecast updateForecast(Long id, SupplyForecast s);
    SupplyForecast getLatestForecast();
    List<SupplyForecast> getAllForecasts();
}
