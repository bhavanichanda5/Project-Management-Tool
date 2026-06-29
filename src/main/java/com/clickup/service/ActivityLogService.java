package com.clickup.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.entity.ActivityLog;
import com.clickup.repository.ActivityLogRepository;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogRepository repo;

    public void saveLog(String action) {

        ActivityLog log = ActivityLog.builder()
                .action(action)
                .createdAt(LocalDateTime.now())
                .build();

        repo.save(log);
    }

    public List<ActivityLog> getAllLogs() {

        return repo.findAll();
    }
}