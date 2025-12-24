package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalDemand;
    private double totalSupply;
    private String status;
    private Instant eventStart;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public double getTotalDemand() {
        return totalDemand;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public String getStatus() {
        return status;
    }

    public Instant getEventStart() {
        return eventStart;
    }

    // ===== SETTERS =====
    public void setTotalDemand(double totalDemand) {
        this.totalDemand = totalDemand;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEventStart(Instant eventStart) {
        this.eventStart = eventStart;
    }
}
