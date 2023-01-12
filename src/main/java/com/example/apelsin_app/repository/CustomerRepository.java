package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(nativeQuery = true, value = "select * from customer where id not in (select customer_id from orders)")
    List<Customer> findAllWithOutOrders();
}
