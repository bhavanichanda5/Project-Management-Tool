package com.clickup.dto;

import lombok.Data;

@Data
public class FolderRequest {

    private String folderName;

    private Long spaceId;
}