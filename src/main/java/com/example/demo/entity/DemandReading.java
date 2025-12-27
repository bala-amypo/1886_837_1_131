package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double demandMW;

    public DemandReading() {
    }

    public DemandReading(Long id, double demandMW) {
        this.id = id;
        this.demandMW = demandMW;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(double demandMW) {
        this.demandMW = demandMW;
    }
}
