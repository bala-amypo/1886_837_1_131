package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DemandReading {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Zone zone;

    private Double demandMW;
    private Instant recordedAt;
}
