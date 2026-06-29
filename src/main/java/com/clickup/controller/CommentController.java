package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.CommentRequest;
import com.clickup.entity.Comment;
import com.clickup.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/create")
    public String createComment(
            @RequestBody CommentRequest request) {

        return service.createComment(request);
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {

        return service.getAllComments();
    }
}