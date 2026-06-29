package com.clickup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickup.dto.TaskRequest;
import com.clickup.entity.Task;
import com.clickup.entity.TaskList;
import com.clickup.entity.User;
import com.clickup.repository.TaskListRepository;
import com.clickup.repository.TaskRepository;
import com.clickup.repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private TaskListRepository taskListRepo;

    @Autowired
    private ActivityLogService logService;
    
    public List<Task> getAllTasks() {
        return repo.findAll();
    }
    
    public String createTask(TaskRequest request) {

        TaskList taskList =
                taskListRepo.findById(
                        request.getTaskListId())
                        .orElse(null);

        if(taskList == null) {
            return "TaskList Not Found";
        }

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(request.getPriority())
                .status(request.getStatus())
                .taskList(taskList)
                .build();

        repo.save(task);

        logService.saveLog(
                "Task Created : " + task.getTitle());

        return "Task Created Successfully";
    }
    
    public String updateTaskStatus(
            Long id,
            String status) {

        Task task = repo.findById(id)
                .orElse(null);

        if(task == null) {
            return "Task Not Found";
        }

        task.setStatus(status);

        repo.save(task);

        return "Task Status Updated";
    }
    
    public String deleteTask(Long id) {

        Task task = repo.findById(id)
                .orElse(null);

        if(task == null) {
            return "Task Not Found";
        }

        repo.delete(task);

        return "Task Deleted Successfully";
    }
    
    public String assignTask(
            Long taskId,
            Long userId) {

        Task task = repo.findById(taskId)
                .orElse(null);

        if(task == null) {
            return "Task Not Found";
        }

        User user = userRepo.findById(userId)
                .orElse(null);

        if(user == null) {
            return "User Not Found";
        }

        task.setAssignedUser(user);

        repo.save(task);

        return "Task Assigned Successfully";
    }
    
    public String updateStatus(
            Long taskId,
            String status) {

        Optional<Task> taskOpt =
                repo.findById(taskId);

        if(taskOpt.isEmpty()) {
            return "Task Not Found";
        }

        Task task = taskOpt.get();

        task.setStatus(status);

        repo.save(task);

        return "Task Status Updated";
    }
    
    public Map<String, Long> getTaskStatusStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("OPEN",
                repo.countByStatus("OPEN"));

        stats.put("IN_PROGRESS",
                repo.countByStatus("IN_PROGRESS"));

        stats.put("COMPLETED",
                repo.countByStatus("COMPLETED"));

        return stats;
    }
}