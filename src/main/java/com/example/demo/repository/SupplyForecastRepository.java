package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface SupplyForecastRepository {
    SupplyForecast save(SupplyForecast f);
    Optional<SupplyForecast> findById(Long id);
    Optional<SupplyForecast> findFirstByOrderByGeneratedAtDesc();
    List<SupplyForecast> findAll();
}
