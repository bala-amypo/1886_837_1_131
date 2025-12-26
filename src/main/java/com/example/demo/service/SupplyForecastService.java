package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import java.util.List;

public interface SupplyForecastService {

    SupplyForecast save(SupplyForecast forecast);

    List<SupplyForecast> getAllForecasts();

    SupplyForecast getForecastById(Long id);
}
