package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.ProjectRequest;
import com.clickup.entity.Project;
import com.clickup.entity.Workspace;
import com.clickup.repository.ProjectRepository;
import com.clickup.repository.WorkspaceRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private WorkspaceRepository workspaceRepo;

    public String createProject(
            ProjectRequest request) {

        Workspace workspace =
                workspaceRepo.findById(
                        request.getWorkspaceId())
                        .orElse(null);

        if(workspace == null) {
            return "Workspace Not Found";
        }

        Project project =
                Project.builder()
                .projectName(request.getProjectName())
                .description(request.getDescription())
                .workspace(workspace)
                .build();

        projectRepo.save(project);

        return "Project Created Successfully";
    }
    
    public List<Project> getAllProjects() {

        return projectRepo.findAll();
    }
}