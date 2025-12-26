package com.example.demo.entity;

import java.time.Instant;

public class LoadSheddingEvent {

    private Long id;
    private Long zoneId;
    private Instant startTime;
    private Instant endTime;
    private String reason;

    // ---------- Getters ----------
    public Long getId() {
        return id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public String getReason() {
        return reason;
    }

    // ---------- Setters ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
