package com.example.apelsin_app.repository;


import com.example.apelsin_app.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
}
