package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.WorkspaceRequest;
import com.clickup.entity.Workspace;
import com.clickup.repository.WorkspaceRepository;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository repo;

    public String createWorkspace(
            WorkspaceRequest request) {

        Workspace workspace =
                Workspace.builder()
                .workspaceName(
                        request.getWorkspaceName())
                .description(
                        request.getDescription())
                .build();

        repo.save(workspace);

        return "Workspace Created Successfully";
    }
    
    public List<Workspace> getAllWorkspaces() {

        return repo.findAll();
    }
    
    public Workspace getWorkspace(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public String updateWorkspace(Long id, WorkspaceRequest request) {

        Workspace workspace = repo.findById(id).orElse(null);

        if (workspace == null) {
            return "Workspace Not Found";
        }

        workspace.setWorkspaceName(request.getWorkspaceName());
        workspace.setDescription(request.getDescription());

        repo.save(workspace);

        return "Workspace Updated Successfully";
    }
}