package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.entity.Invoice;
import com.example.apelsin_app.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/task")
@RequiredArgsConstructor
public class TasksController {
    final InvoiceRepository invoiceRepository;

    @GetMapping("/expired_invoice")
    public HttpEntity<?> get1() {
        return ResponseEntity.ok().body(invoiceRepository.findAllByIssuedAfterDue());
    }




}
