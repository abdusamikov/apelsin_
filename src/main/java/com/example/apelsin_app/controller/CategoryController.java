package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.entity.Category;
import com.example.apelsin_app.repository.CategoryRepository;
import com.example.apelsin_app.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/aoi/category")
public class CategoryController {
    final CategoryRepository repository;
    final CategoryService categoryService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody String name){
        ApiResponse<Category> add = categoryService.add(name);
        return ResponseEntity.status(add.isSuccess()?200:400).body(add);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id ,@RequestBody String name){
        ApiResponse edit = categoryService.edit(id, name);
        return ResponseEntity.status(edit.isSuccess()?200:400).body(edit);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        Optional<Category> byId = repository.findById(id);
        return ResponseEntity.ok().body(byId);
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        List<Category> all = repository.findAll();
        return ResponseEntity.ok().body(all);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id){
        boolean b = repository.existsById(id);
        return ResponseEntity.ok().body("deleted");
    }
}
