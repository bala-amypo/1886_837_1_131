package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface SupplyForecastRepository {
    Optional<SupplyForecast> findFirstByOrderByGeneratedAtDesc();
    Optional<SupplyForecast> findById(Long id);
    List<SupplyForecast> findAll();
    SupplyForecast save(SupplyForecast s);
}
