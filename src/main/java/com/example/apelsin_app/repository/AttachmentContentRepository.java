package com.example.apelsin_app.repository;
import com.example.apelsin_app.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {
    Optional<AttachmentContent> findByAttachment_id(Long attachment_id);
}