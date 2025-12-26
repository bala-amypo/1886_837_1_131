package com.example.demo.entity;

import java.time.Instant;

public class ZoneRestorationRecord {

    private Long id;
    private Long eventId;
    private Long zoneId;
    private Instant restoredAt;

    public Long getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Instant getRestoredAt() {
        return restoredAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public void setRestoredAt(Instant restoredAt) {
        this.restoredAt = restoredAt;
    }
}
