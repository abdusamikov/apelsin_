package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paymentrepository extends JpaRepository<Payment,Long> {
}
