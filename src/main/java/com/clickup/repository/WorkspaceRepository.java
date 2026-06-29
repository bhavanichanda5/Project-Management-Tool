package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Workspace;

public interface WorkspaceRepository
        extends JpaRepository<Workspace, Long> {

}