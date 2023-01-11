package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.entity.Category;
import com.example.apelsin_app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;

    public ApiResponse<Category> add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return ApiResponse.<Category>builder().success(true).message("added").build();
    }

    public ApiResponse edit(Integer id, String name) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        category.setName(name);
        category.setId(id);
        categoryRepository.save(category);
        return ApiResponse.builder().success(true).message("edited").build();
    }

}
