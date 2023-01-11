package com.example.apelsin_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    @Builder.Default
    private boolean success = false;
    private String message;
    private T obj;
}
