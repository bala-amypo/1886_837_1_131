package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;

    private double demandMW;

    private Instant createdAt;

    public LoadSheddingEvent() {
    }

    public LoadSheddingEvent(Long id, Long zoneId, double demandMW, Instant createdAt) {
        this.id = id;
        this.zoneId = zoneId;
        this.demandMW = demandMW;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(double demandMW) {
        this.demandMW = demandMW;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
