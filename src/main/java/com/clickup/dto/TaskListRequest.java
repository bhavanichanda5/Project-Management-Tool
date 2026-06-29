package com.clickup.dto;

import lombok.Data;

@Data
public class TaskListRequest {

    private String listName;

    private Long folderId;
}