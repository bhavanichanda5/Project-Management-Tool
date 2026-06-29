package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.SpaceRequest;
import com.clickup.entity.Space;
import com.clickup.service.SpaceService;

@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    private SpaceService service;

    @PostMapping("/create")
    public String createSpace(
            @RequestBody SpaceRequest request) {

        return service.createSpace(request);
    }

    @GetMapping("/all")
    public List<Space> getAllSpaces() {

        return service.getAllSpaces();
    }
}