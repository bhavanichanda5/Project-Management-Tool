package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.TaskRequest;
import com.clickup.dto.TaskStatusRequest;
import com.clickup.entity.Task;
import com.clickup.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/all")
    public List<Task> getAllTasks() {

        return service.getAllTasks();
    }
    
    @PostMapping("/create")
    public String createTask(
            @RequestBody TaskRequest request) {

        return service.createTask(request);
    }
    
    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Long id) {

        return service.deleteTask(id);
    }
    
    @PutMapping("/{taskId}/assign/{userId}")
    public String assignTask(
            @PathVariable Long taskId,
            @PathVariable Long userId) {

        return service.assignTask(
                taskId,
                userId);
    }


    @PutMapping("/{taskId}/status")
    public String updateStatus(
            @PathVariable Long taskId,
            @RequestBody TaskStatusRequest request) {

        return service.updateStatus(
                taskId,
                request.getStatus());
    }
}