package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Long> {
//    List<Detail> findAllByOrd_id(Long ord_id);
}
