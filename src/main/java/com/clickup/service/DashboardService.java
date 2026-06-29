package com.clickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.DashboardResponse;
import com.clickup.repository.AttachmentRepository;
import com.clickup.repository.CommentRepository;
import com.clickup.repository.FolderRepository;
import com.clickup.repository.ProjectRepository;
import com.clickup.repository.SpaceRepository;
import com.clickup.repository.TaskListRepository;
import com.clickup.repository.TaskRepository;
import com.clickup.repository.UserRepository;
import com.clickup.repository.WorkspaceRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WorkspaceRepository workspaceRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private SpaceRepository spaceRepo;

    @Autowired
    private FolderRepository folderRepo;

    @Autowired
    private TaskListRepository taskListRepo;

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private AttachmentRepository attachmentRepo;

    public DashboardResponse getStats() {

        return DashboardResponse.builder()
                .users(userRepo.count())
                .workspaces(workspaceRepo.count())
                .projects(projectRepo.count())
                .spaces(spaceRepo.count())
                .folders(folderRepo.count())
                .taskLists(taskListRepo.count())
                .tasks(taskRepo.count())
                .comments(commentRepo.count())
                .attachments(attachmentRepo.count())
                .build();
    }
}