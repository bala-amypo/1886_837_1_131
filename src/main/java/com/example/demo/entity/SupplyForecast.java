package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SupplyForecast {

    @Id
    @GeneratedValue
    private Long id;

    private Double availableSupplyMW;
    private Instant forecastStart;
    private Instant forecastEnd;
    private Instant generatedAt;

    @PrePersist
    void gen() {
        generatedAt = Instant.now();
    }
}
