package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Detail;
import com.example.apelsin_app.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    @Query(nativeQuery = true, value = "select * from invoice where issued>invoice.due")
    List<Invoice> findAllByIssuedAfterDue();
}
