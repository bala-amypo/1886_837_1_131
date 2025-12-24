package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Zone zone;

    private Long demandMW;
    private Instant recordedAt;

    public Long getId() { return id; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }

    public Long getDemandMW() { return demandMW; }
    public void setDemandMW(Long demandMW) { this.demandMW = demandMW; }

    public Instant getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Instant recordedAt) { this.recordedAt = recordedAt; }
}
