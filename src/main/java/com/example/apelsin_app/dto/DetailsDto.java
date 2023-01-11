package com.example.apelsin_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailsDto {
    private String product_name;
    private Integer quantity;
}
