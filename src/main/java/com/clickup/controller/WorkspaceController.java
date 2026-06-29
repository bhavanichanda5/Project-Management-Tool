package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.WorkspaceRequest;
import com.clickup.entity.Workspace;
import com.clickup.service.WorkspaceService;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceService service;

    @PostMapping("/create")
    public String createWorkspace(
            @RequestBody WorkspaceRequest request) {

        return service.createWorkspace(request);
    }
    
    @GetMapping("/all")
    public List<Workspace> getAllWorkspaces() {

        return service.getAllWorkspaces();
    }
    
    @GetMapping("/{id}")
    public Workspace getWorkspace(@PathVariable Long id) {
        return service.getWorkspace(id);
    }
    
    @PutMapping("/{id}")
    public String updateWorkspace(
            @PathVariable Long id,
            @RequestBody WorkspaceRequest request) {

        System.out.println("PUT API HIT");

        return service.updateWorkspace(id, request);
    }
}