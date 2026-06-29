package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.TaskListRequest;
import com.clickup.entity.TaskList;
import com.clickup.service.TaskListService;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {

    @Autowired
    private TaskListService service;

    @PostMapping("/create")
    public String createTaskList(
            @RequestBody TaskListRequest request) {

        return service.createTaskList(request);
    }

    @GetMapping("/all")
    public List<TaskList> getAllTaskLists() {

        return service.getAllTaskLists();
    }
}