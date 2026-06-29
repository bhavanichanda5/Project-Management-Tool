package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Task;

public interface TaskRepository
        extends JpaRepository<Task, Long> 
{
	 long countByStatus(String status);
}