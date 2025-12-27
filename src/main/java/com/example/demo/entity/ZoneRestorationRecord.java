package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;

    private Instant restoredAt;

    public ZoneRestorationRecord() {
    }

    public ZoneRestorationRecord(Long id, Long zoneId, Instant restoredAt) {
        this.id = id;
        this.zoneId = zoneId;
        this.restoredAt = restoredAt;
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

    public Instant getRestoredAt() {
        return restoredAt;
    }

    public void setRestoredAt(Instant restoredAt) {
        this.restoredAt = restoredAt;
    }
}
