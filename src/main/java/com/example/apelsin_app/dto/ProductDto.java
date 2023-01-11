package com.example.apelsin_app.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String name;

    private String descreption;
    private float price;
    private Integer category_id;

    private MultipartFile photo;


}
