package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.ApiResponse;
import com.example.apelsin_app.dto.CustomerDto;
import com.example.apelsin_app.dto.OrderDto;
import com.example.apelsin_app.entity.Customer;
import com.example.apelsin_app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
 public class CustomerService {
final CustomerRepository customerRepository;

public ApiResponse<Customer> add(CustomerDto customerDto){
    Customer customer = new Customer();
    customer.setAddress(customerDto.getAddress());
    customer.setCountry(customerDto.getCountry());
    customer.setName(customerDto.getName());
    customer.setPhone(customerDto.getPhone());
    customerRepository.save(customer);
    return ApiResponse.<Customer>builder().success(true).message("added").build();
}

public ApiResponse<Customer>edit (Long id,CustomerDto customerDto){
    Optional<Customer> byId = customerRepository.findById(id);
    Customer customer = byId.get();
    customer.setAddress(customerDto.getAddress());
    customer.setCountry(customerDto.getCountry());
    customer.setName(customerDto.getName());
    customer.setPhone(customerDto.getPhone());
    customer.setId(id);
    customerRepository.save(customer);
    return ApiResponse.<Customer>builder().success(true).message("edited").build();
}





}
