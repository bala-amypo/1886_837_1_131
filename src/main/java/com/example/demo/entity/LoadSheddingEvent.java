package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;

    // ⚠ TEST EXPECTS THIS NAME EXACTLY
    private Instant eventStart;

    // ⚠ TEST EXPECTS DEFAULT VALUE
    private String status;
}
