package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.FolderRequest;
import com.clickup.entity.Folder;
import com.clickup.service.FolderService;

@RestController
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private FolderService service;

    @PostMapping("/create")
    public String createFolder(
            @RequestBody FolderRequest request) {

        return service.createFolder(request);
    }

    @GetMapping("/all")
    public List<Folder> getAllFolders() {

        return service.getAllFolders();
    }
}