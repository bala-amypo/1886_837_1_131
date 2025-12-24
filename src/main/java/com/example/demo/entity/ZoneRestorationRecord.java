package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Zone zone;

    @ManyToOne
    private LoadSheddingEvent event;

    private Instant restoredAt;

    public Long getId() { return id; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }

    public LoadSheddingEvent getEvent() { return event; }
    public void setEvent(LoadSheddingEvent event) { this.event = event; }

    public Instant getRestoredAt() { return restoredAt; }
    public void setRestoredAt(Instant restoredAt) { this.restoredAt = restoredAt; }
}
