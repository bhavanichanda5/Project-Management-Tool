package com.clickup.dto;

import lombok.Data;

@Data
public class WorkspaceRequest {

    private String workspaceName;

    private String description;
}