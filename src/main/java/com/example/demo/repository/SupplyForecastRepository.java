package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SupplyForecast;

public interface SupplyForecastRepository extends JpaRepository<SupplyForecast, Long> {

    // ✅ FIELD NAME MATCHES ENTITY
    SupplyForecast findFirstByOrderByGeneratedAtDesc();
}
