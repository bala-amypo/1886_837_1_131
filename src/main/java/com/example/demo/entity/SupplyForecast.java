package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate forecastDate;

    private double quantity;

    // ✅ MUST EXIST because repository uses it
    private LocalDateTime generatedAt;

    // ✅ Required by JPA
    public SupplyForecast() {
        this.generatedAt = LocalDateTime.now();
    }

    // ✅ Required by Service
    public SupplyForecast(Long id, LocalDate forecastDate, double quantity) {
        this.id = id;
        this.forecastDate = forecastDate;
        this.quantity = quantity;
        this.generatedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getForecastDate() { return forecastDate; }
    public void setForecastDate(LocalDate forecastDate) { this.forecastDate = forecastDate; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
