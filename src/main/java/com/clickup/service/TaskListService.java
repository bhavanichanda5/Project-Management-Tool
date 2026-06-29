package com.clickup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.TaskListRequest;
import com.clickup.entity.Folder;
import com.clickup.entity.TaskList;
import com.clickup.repository.FolderRepository;
import com.clickup.repository.TaskListRepository;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository repo;

    @Autowired
    private FolderRepository folderRepo;

    public String createTaskList(
            TaskListRequest request) {

        Folder folder =
                folderRepo.findById(
                        request.getFolderId())
                        .orElse(null);

        if(folder == null) {
            return "Folder Not Found";
        }

        TaskList taskList = TaskList.builder()
                .listName(request.getListName())
                .folder(folder)
                .build();

        repo.save(taskList);

        return "TaskList Created Successfully";
    }

    public List<TaskList> getAllTaskLists() {

        return repo.findAll();
    }
}