package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.dto.CustomerDto;
import com.example.apelsin_app.dto.OrderDto;
import com.example.apelsin_app.entity.Customer;
import com.example.apelsin_app.repository.CustomerRepository;
import com.example.apelsin_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService service;

    final CustomerRepository repository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody CustomerDto dto) {
        ApiResponse<Customer> add = service.add(dto);
        return ResponseEntity.status(add.isSuccess() ? 200 : 400).body(add);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edeit(@PathVariable Long id, CustomerDto dto){
        ApiResponse<Customer> edit = service.edit(id, dto);
        return ResponseEntity.status(edit.isSuccess()?200:400).body(edit);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id){
        Optional<Customer> byId = repository.findById(id);
        return ResponseEntity.ok().body(byId);
    }
    @GetMapping
    public HttpEntity<?> getAll (){
        List<Customer> all = repository.findAll();
        return ResponseEntity.ok().body(all);
    }


}
