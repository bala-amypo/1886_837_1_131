package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double availableSupplyMW;

    private Instant forecastStart;

    private Instant forecastEnd;

    private Instant generatedAt;

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public double getAvailableSupplyMW() {
        return availableSupplyMW;
    }

    public void setAvailableSupplyMW(double availableSupplyMW) {
        this.availableSupplyMW = availableSupplyMW;
    }

    public Instant getForecastStart() {
        return forecastStart;
    }

    public void setForecastStart(Instant forecastStart) {
        this.forecastStart = forecastStart;
    }

    public Instant getForecastEnd() {
        return forecastEnd;
    }

    public void setForecastEnd(Instant forecastEnd) {
        this.forecastEnd = forecastEnd;
    }

    public Instant getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Instant generatedAt) {
        this.generatedAt = generatedAt;
    }
}
