package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LoadSheddingEvent {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Zone zone;

    private Instant eventStart;
    private Instant eventEnd;
    private String reason;
    private Long triggeredByForecastId;
    private Double expectedDemandReductionMW;
}
