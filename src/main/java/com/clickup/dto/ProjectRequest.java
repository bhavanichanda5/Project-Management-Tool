package com.clickup.dto;

import lombok.Data;

@Data
public class ProjectRequest {

    private String projectName;

    private String description;

    private Long workspaceId;
}