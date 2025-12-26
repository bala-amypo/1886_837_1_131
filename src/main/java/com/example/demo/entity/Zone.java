package com.example.demo.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Zone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String zoneName;

    private Integer priorityLevel;
    private Integer population;
    private Boolean active = true;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
        if (active == null) active = true;
    }
}
