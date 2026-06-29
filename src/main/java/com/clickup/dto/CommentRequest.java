package com.clickup.dto;

import lombok.Data;

@Data
public class CommentRequest {

    private String message;

    private Long taskId;
}