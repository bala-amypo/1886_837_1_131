package com.example.demo.entity;

import java.time.Instant;

public class LoadSheddingEvent {

    private Long id;
    private Long zoneId;
    private Instant eventTime = Instant.now();

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

    public Instant getEventTime() {
        return eventTime;
    }
}
