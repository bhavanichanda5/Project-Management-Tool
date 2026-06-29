package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.entity.ActivityLog;
import com.clickup.service.ActivityLogService;

@RestController
public class ActivityLogController {

    @Autowired
    private ActivityLogService service;

    @GetMapping("/activity/all")
    public List<ActivityLog> getAllLogs() {

        return service.getAllLogs();
    }
}