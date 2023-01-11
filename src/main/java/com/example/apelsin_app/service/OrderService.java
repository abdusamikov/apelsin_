package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.*;
import com.example.apelsin_app.entity.*;
import com.example.apelsin_app.repository.*;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("orderService")
@RequiredArgsConstructor

public class OrderService {
    final OrderRepository orderRepository;
    final CustomerRepository customerRepository;
    final ProductRepository productRepository;
    final DetailRepository detailRepository;
    final InvoiceRepository invoiceRepository;
    public ApiResponse add(OrderDto orderDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(orderDto.getCustomer_id());
        if (optionalCustomer.isEmpty()) {
            return new ApiResponse(false,"Customer not found",null);
        }
        Order order=new Order();
        order.setDate(LocalDate.now());
        order.setCustomer(optionalCustomer.get());
        Order save = orderRepository.save(order);
        double total=0D;
        for (DetailDto product : orderDto.getProducts()) {
            Detail detail=new Detail();
            Optional<Product> optionalProduct = productRepository.findById(product.getProduct_id());
            if (optionalProduct.isEmpty()) {
                continue;
            }
            detail.setOrder(save);
            detail.setQuantity(product.getQuantity());
            detail.setProduct(optionalProduct.get());
            detailRepository.save(detail);
            total+=(optionalProduct.get().getPrice()*product.getQuantity());
        }
        Invoice invoice=new Invoice();
        invoice.setOrder(save);
        invoice.setAmount(total);
        invoice.setIssued(LocalDate.now());
        invoice.setDue(LocalDate.now().plusDays(3));
        Invoice savedInvoice = invoiceRepository.save(invoice);
        Map<String, Long> response=new LinkedHashMap<>();
        response.put("invoice_number", savedInvoice.getId());
        return new ApiResponse(true,"Saved", response);
    }
//    public OrderDetails getDetails(Long id) {
//        Optional<Order> byId = orderRepository.findById(id);
//        if(byId.isEmpty()){
//            return null;
//        }
//        List<DetailsDto> detailsDtos = detailRepository.findAllByOrd_id(id).stream()
//                .map(detail -> new DetailsDto(detail.getProduct().getName(),  detail.getQuantity())).toList();
//        return new OrderDetails(byId.get(), detailsDtos);
//    }
}
