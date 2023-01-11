package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ProductDto;
import com.example.apelsin_app.entity.Product;
import com.example.apelsin_app.repository.ProductRepository;
import com.example.apelsin_app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    final ProductRepository productRepository;
    final ProductService productService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDto dto) {
        productService.save(dto);
        return ResponseEntity.ok().body("added");
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.edit(id, productDto);
        return ResponseEntity.ok("edited");
    }

    @DeleteMapping("/deleet/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {

        boolean b = productRepository.existsById(id);
        return ResponseEntity.ok("deleted");

    }

    @GetMapping("/{id}/photo")
    public HttpEntity<?> getPhoto(@PathVariable Long id){
        return productService.getPhoto(id);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id){
        Optional<Product> byId = productRepository.findById(id);
        return ResponseEntity.ok().body(byId.get());
    }

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Product> all = productRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

}
