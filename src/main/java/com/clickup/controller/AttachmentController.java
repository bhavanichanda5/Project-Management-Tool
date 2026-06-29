package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clickup.dto.AttachmentRequest;
import com.clickup.entity.Attachment;
import com.clickup.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService service;

    @PostMapping("/create")
    public String createAttachment(
            @RequestBody AttachmentRequest request) {

        return service.createAttachment(request);
    }

    @GetMapping("/all")
    public List<Attachment> getAllAttachments() {

        return service.getAllAttachments();
    }
}