package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "zone_restoration_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Zone zone;

    private Instant restoredAt; // must be AFTER eventStart

    private Long eventId;

    private String notes;
}
