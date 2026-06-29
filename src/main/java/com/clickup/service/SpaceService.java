package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.SpaceRequest;
import com.clickup.entity.Space;
import com.clickup.entity.Workspace;
import com.clickup.repository.SpaceRepository;
import com.clickup.repository.WorkspaceRepository;

@Service
public class SpaceService {

    @Autowired
    private SpaceRepository repo;

    @Autowired
    private WorkspaceRepository workspaceRepo;

    public String createSpace(
            SpaceRequest request) {

        Workspace workspace =
                workspaceRepo.findById(
                        request.getWorkspaceId())
                        .orElse(null);

        if(workspace == null) {
            return "Workspace Not Found";
        }

        Space space = Space.builder()
                .spaceName(request.getSpaceName())
                .workspace(workspace)
                .build();

        repo.save(space);

        return "Space Created Successfully";
    }

    public List<Space> getAllSpaces() {
        return repo.findAll();
    }
}