package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;

    private Instant eventStart;   // 🔥 REQUIRED FIELD

    private Instant eventEnd;

    private Double totalDemand;

    private Double totalSupply;

    private String status;
}
