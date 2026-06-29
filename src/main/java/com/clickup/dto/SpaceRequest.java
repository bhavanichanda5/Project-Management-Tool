package com.clickup.dto;

import lombok.Data;

@Data
public class SpaceRequest {

    private String spaceName;

    private Long workspaceId;
}