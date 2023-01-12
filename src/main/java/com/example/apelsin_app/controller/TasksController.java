package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.entity.Invoice;
import com.example.apelsin_app.repository.CustomerRepository;
import com.example.apelsin_app.repository.InvoiceRepository;
import com.example.apelsin_app.repository.OrderRepository;
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
    final CustomerRepository customerRepository;
    final OrderRepository orderRepository;


    @GetMapping("/expired_invoice")
    public HttpEntity<?> ex1() {
        return ResponseEntity.ok().body(invoiceRepository.findAllByIssuedAfterDue());
    }

    @GetMapping("customers_withOut_order")
    public HttpEntity<?> ex2(){
        return ResponseEntity.ok().body(customerRepository.findAllWithOutOrders());
    }

    @GetMapping("wrong_date_invoice")
    public HttpEntity<?> ex3(){
        return ResponseEntity.ok().body(invoiceRepository.findAllBywrongDateInvoice());
    }

    @GetMapping("orders_without_detail")
    public HttpEntity<?> ex4(){
        return ResponseEntity.ok().body(orderRepository.findAllByOrderWithOutDetails());
    }

    @GetMapping("orders_without_invoice")
    public HttpEntity<?> getOrdersWithOutInvoice(){
        return ResponseEntity.ok().body(orderRepository.findAllByOrderWithOutInvoice());
    }



}
