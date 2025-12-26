package com.example.demo.entity;

import java.time.Instant;

public class DemandReading {

    private Long id;
    private Long zoneId;
    private double demandMW;
    private Instant recordedAt;

    public Long getId() {
        return id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public double getDemandMW() {
        return demandMW;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public void setDemandMW(double demandMW) {
        this.demandMW = demandMW;
    }

    public void setRecordedAt(Instant recordedAt) {
        this.recordedAt = recordedAt;
    }
}
