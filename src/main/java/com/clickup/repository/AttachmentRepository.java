package com.clickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickup.entity.Attachment;

public interface AttachmentRepository
        extends JpaRepository<Attachment, Long> {

}