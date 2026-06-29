package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.CommentRequest;
import com.clickup.entity.Comment;
import com.clickup.entity.Task;
import com.clickup.repository.CommentRepository;
import com.clickup.repository.TaskRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private TaskRepository taskRepo;

    public String createComment(CommentRequest request) {

        Task task = taskRepo.findById(
                request.getTaskId())
                .orElse(null);

        if(task == null) {
            return "Task Not Found";
        }

        Comment comment = Comment.builder()
                .message(request.getMessage())
                .task(task)
                .build();

        commentRepo.save(comment);

        return "Comment Added Successfully";
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}