package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RepositoryOrder extends JpaRepository<Order,Integer> {
}
