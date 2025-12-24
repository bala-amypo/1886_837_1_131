package com.example.demo.repository;

import com.example.demo.entity.ZoneRestorationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRestorationRepository
        extends JpaRepository<ZoneRestorationRecord, Long> {
}
