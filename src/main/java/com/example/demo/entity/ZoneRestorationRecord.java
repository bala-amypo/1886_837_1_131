package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Zone zone;

    private Instant restoredAt;
    private Long eventId;
    private String notes;
}
