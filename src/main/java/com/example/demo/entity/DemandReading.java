package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String readingName;
    private Double value;

    // Constructors
    public DemandReading() {}

    public DemandReading(String readingName, Double value) {
        this.readingName = readingName;
        this.value = value;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReadingName() { return readingName; }
    public void setReadingName(String readingName) { this.readingName = readingName; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
}
