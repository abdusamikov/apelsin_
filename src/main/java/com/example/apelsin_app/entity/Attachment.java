package com.example.apelsin_app.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size",nullable = false)
    private Long size;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "content_type", nullable = false)
    private String content_type;

}
