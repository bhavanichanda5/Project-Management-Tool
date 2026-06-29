package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Folder;

public interface FolderRepository
        extends JpaRepository<Folder, Long> {

}