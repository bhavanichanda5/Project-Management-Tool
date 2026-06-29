package com.clickup.dto;

import lombok.Data;

@Data
public class TaskRequest {

    private String title;

    private String description;

    private String priority;

    private String status;

    private Long taskListId;

    private Long assignedUserId;
    
    
    
}