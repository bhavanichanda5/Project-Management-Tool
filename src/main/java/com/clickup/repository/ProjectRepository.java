package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

}