package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Space;

public interface SpaceRepository
        extends JpaRepository<Space, Long> {

}