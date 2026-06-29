package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.ProjectRequest;
import com.clickup.entity.Project;
import com.clickup.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/create")
    public String createProject(
            @RequestBody ProjectRequest request) {

        return service.createProject(request);
    }
    
    @GetMapping("/all")
    public List<Project> getAllProjects() {

        return service.getAllProjects();
    }
}