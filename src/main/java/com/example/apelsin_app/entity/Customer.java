package com.example.apelsin_app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.boot.convert.DataSizeUnit;
import org.w3c.dom.Text;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    private String address;
    private String phone;
}
