package com.example.demo.entity;

import java.time.Instant;

public class SupplyForecast {
    private Long id;
    private double availableSupplyMW;
    private Instant generatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAvailableSupplyMW() { return availableSupplyMW; }
    public void setAvailableSupplyMW(double availableSupplyMW) {
        this.availableSupplyMW = availableSupplyMW;
    }

    public Instant getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Instant generatedAt) { this.generatedAt = generatedAt; }
}
