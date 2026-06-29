package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.AttachmentRequest;
import com.clickup.entity.Attachment;
import com.clickup.entity.Task;
import com.clickup.repository.AttachmentRepository;
import com.clickup.repository.TaskRepository;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepo;

    @Autowired
    private TaskRepository taskRepo;

    public String createAttachment(
            AttachmentRequest request) {

        Task task = taskRepo.findById(
                request.getTaskId())
                .orElse(null);

        if(task == null) {
            return "Task Not Found";
        }

        Attachment attachment = Attachment.builder()
                .fileName(request.getFileName())
                .task(task)
                .build();

        attachmentRepo.save(attachment);

        return "Attachment Added Successfully";
    }

    public List<Attachment> getAllAttachments() {

        return attachmentRepo.findAll();
    }
}