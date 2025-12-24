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

    public ZoneRestorationRecord() { }

    public ZoneRestorationRecord(Long id, Long zoneId, LocalDateTime time, String status) {
        this.id = id;
        this.zoneId = zoneId;
        this.time = time;
        this.status = status;
    }

    // ✅ Add this constructor for 2 parameters
    public ZoneRestorationRecord(Long id, Long zoneId) {
        this.id = id;
        this.zoneId = zoneId;
        this.time = LocalDateTime.now(); // default current time
        this.status = "PENDING";         // default status
    }

    // getters and setters ...
}
