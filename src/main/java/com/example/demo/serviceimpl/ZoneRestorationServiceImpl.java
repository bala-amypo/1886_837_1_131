package com.example.demo.serviceimpl;

import com.example.demo.entity.ZoneRestorationRecord;
import com.example.demo.repository.ZoneRestorationRepository;
import com.example.demo.service.ZoneRestorationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneRestorationServiceImpl implements ZoneRestorationService {

    private final ZoneRestorationRepository repo;

    public ZoneRestorationServiceImpl(ZoneRestorationRepository repo) {
        this.repo = repo;
    }

    @Override
    public ZoneRestorationRecord restoreZone(ZoneRestorationRecord record) {
        return repo.save(record);
    }

    @Override
    public List<ZoneRestorationRecord> getAllRecords() {
        return repo.findAll();
    }

    @Override
    public void deleteRecord(Long id) {
        repo.deleteById(id);
    }
}
