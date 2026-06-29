package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Comment;

public interface CommentRepository
        extends JpaRepository<Comment, Long> {

}