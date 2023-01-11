package com.example.apelsin_app.entity;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String descreption;
    private float price;
    @OneToOne()
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @ManyToOne
    private Category category;

}
