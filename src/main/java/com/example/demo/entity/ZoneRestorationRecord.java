package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;
    private LocalDateTime time;
    private String status;

    public ZoneRestorationRecord() {}

    public ZoneRestorationRecord(Long zoneId, LocalDateTime time, String status) {
        this.zoneId = zoneId;
        this.time = time;
        this.status = status;
    }

    // Getters and setters
    public Long getId() { return id; }
    public Long getZoneId() { return zoneId; }
    public void setZoneId(Long zoneId) { this.zoneId = zoneId; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
