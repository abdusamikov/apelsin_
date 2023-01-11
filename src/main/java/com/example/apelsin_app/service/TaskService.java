package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.entity.Invoice;
import com.example.apelsin_app.entity.Order;
import com.example.apelsin_app.repository.CustomerRepository;
import com.example.apelsin_app.repository.InvoiceRepository;
import com.example.apelsin_app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    final CustomerRepository customerRepository;
    final OrderRepository orderRepository;

//    public ApiResponse getCustomersWithOutOrders(){
//        List<Order> orders = new ArrayList<>();
//
//        for (Order order : orderRepository.findAll()) {
//            if ()
//        }
//    }

}
