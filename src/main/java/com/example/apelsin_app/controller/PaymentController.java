package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.PaymentDto;
import com.example.apelsin_app.entity.Payment;
import com.example.apelsin_app.repository.Paymentrepository;
import com.example.apelsin_app.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {
final Paymentrepository paymentrepository;
    final PaymentService service;
    @PostMapping
    public HttpEntity<?> add(PaymentDto dto){
        service.add(dto);
        return ResponseEntity.ok().body("added");
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne (@PathVariable Long id){
        Optional<Payment> byId = paymentrepository.findById(id);
        return ResponseEntity.ok().body(byId.get());
    }
}
