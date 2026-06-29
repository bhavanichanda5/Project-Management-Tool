package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.FolderRequest;
import com.clickup.entity.Folder;
import com.clickup.entity.Space;
import com.clickup.repository.FolderRepository;
import com.clickup.repository.SpaceRepository;

@Service
public class FolderService {

    @Autowired
    private FolderRepository repo;

    @Autowired
    private SpaceRepository spaceRepo;

    public String createFolder(
            FolderRequest request) {

        Space space =
                spaceRepo.findById(
                        request.getSpaceId())
                        .orElse(null);

        if(space == null) {
            return "Space Not Found";
        }

        Folder folder = Folder.builder()
                .folderName(request.getFolderName())
                .space(space)
                .build();

        repo.save(folder);

        return "Folder Created Successfully";
    }

    public List<Folder> getAllFolders() {
        return repo.findAll();
    }
}