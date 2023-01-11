package com.example.apelsin_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDto {
    private Long product_id;
    private Integer quantity;
}
