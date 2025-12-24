package com.example.demo.repository;

import com.example.demo.entity.LoadSheddingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadSheddingRepository
        extends JpaRepository<LoadSheddingEvent, Long> {
}
