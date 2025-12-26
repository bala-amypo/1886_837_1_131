package com.example.demo.entity;

import java.time.Instant;

public class SupplyForecast {

    private Long id;
    private double availableSupplyMW;
    private Instant forecastStart;
    private Instant forecastEnd;
    private Instant generatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAvailableSupplyMW() { return availableSupplyMW; }
    public void setAvailableSupplyMW(double availableSupplyMW) {
        this.availableSupplyMW = availableSupplyMW;
    }

    public Instant getForecastStart() { return forecastStart; }
    public void setForecastStart(Instant forecastStart) {
        this.forecastStart = forecastStart;
    }

    public Instant getForecastEnd() { return forecastEnd; }
    public void setForecastEnd(Instant forecastEnd) {
        this.forecastEnd = forecastEnd;
    }

    public Instant getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Instant generatedAt) {
        this.generatedAt = generatedAt;
    }
}
