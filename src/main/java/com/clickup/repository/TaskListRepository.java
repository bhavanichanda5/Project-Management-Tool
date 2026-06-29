package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.TaskList;

public interface TaskListRepository
extends JpaRepository<TaskList, Long> {
}
