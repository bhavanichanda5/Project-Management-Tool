package com.clickup.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.DashboardResponse;
import com.clickup.service.DashboardService;
import com.clickup.service.TaskService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/stats")
    public DashboardResponse getStats() {
        return service.getStats();
    }
    
    @GetMapping("/task-status")
    public Map<String, Long> getTaskStatusStats() {

        return taskService.getTaskStatusStats();
    }
}