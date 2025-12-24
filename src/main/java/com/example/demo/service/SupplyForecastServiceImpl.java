package com.example.demo.service.impl;

import com.example.demo.entity.SupplyForecast;
import org.springframework.stereotype.Service;

@Service
public class SupplyForecastService {

    public SupplyForecast save(SupplyForecast forecast) {
        return forecast;
    }

    public SupplyForecast getLatest() {
        return SupplyForecast.builder().build();
    }
}
package com.example.demo.service;

import com.example.demo.entity.SupplyForecast;
import org.springframework.stereotype.Service;

@Service
public class SupplyForecastServiceImpl {

    public SupplyForecast save(SupplyForecast s) {
        return s;
    }

    public SupplyForecast getLatest() {
        return new SupplyForecast();
    }
}
