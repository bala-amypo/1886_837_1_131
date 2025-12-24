package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "demand_readings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Zone zone;

    private Double demandMW;  // >=0

    private Instant recordedAt;  // not future

    @PrePersist
    public void prePersist() {
        if (recordedAt == null) recordedAt = Instant.now();
    }
}
