package com.example.apelsin_app.controller;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.dto.OrderDto;
import com.example.apelsin_app.repository.DetailRepository;
import com.example.apelsin_app.repository.OrderRepository;
import com.example.apelsin_app.service.OrderService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
@Table(name = "ordersController")
public class OrderController {
    final OrderService orderService;
    final OrderRepository orderRepository;
    final DetailRepository detailRepository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody OrderDto orderDto){
        ApiResponse apiResponse=orderService.add(orderDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:400).body(apiResponse);
    }
//    @GetMapping("/details")
//    public HttpEntity<?> getOne(@PathVariable Long id){
//        if (!orderRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(orderService.getDetails(id));
//    }
}
