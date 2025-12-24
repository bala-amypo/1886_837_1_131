package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "supply_forecasts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double availableSupplyMW; // >=0

    private Instant forecastStart;
    private Instant forecastEnd;

    private Instant generatedAt;

    @PrePersist
    public void onCreate() {
        generatedAt = Instant.now();
    }
}
