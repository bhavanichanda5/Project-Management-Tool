package com.clickup.dto;

import lombok.Data;

@Data
public class AttachmentRequest {

    private String fileName;

    private Long taskId;
}