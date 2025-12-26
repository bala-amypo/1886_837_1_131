package com.example.demo.entity;

import java.time.Instant;

public class DemandReading {

    private Long id;
    private Zone zone;
    private Double demandMW;
    private Instant recordedAt;

    public DemandReading() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
package com.example.demo.entity;

import java.time.Instant;

public class DemandReading {
    private Long id;
    private Zone zone;
    private double demandMW;
    private Instant recordedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }

    public double getDemandMW() { return demandMW; }
    public void setDemandMW(double demandMW) { this.demandMW = demandMW; }

    public Instant getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Instant recordedAt) { this.recordedAt = recordedAt; }
}

    public Double getDemandMW() { return demandMW; }
    public void setDemandMW(Double demandMW) { this.demandMW = demandMW; }

    public Instant getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Instant recordedAt) { this.recordedAt = recordedAt; }
}
