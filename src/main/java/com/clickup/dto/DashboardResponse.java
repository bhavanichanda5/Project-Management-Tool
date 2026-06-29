package com.clickup.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private long users;

    private long workspaces;

    private long projects;

    private long spaces;

    private long folders;

    private long taskLists;

    private long tasks;

    private long comments;

    private long attachments;
}