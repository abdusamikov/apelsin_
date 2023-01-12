package com.example.apelsin_app.repository;

import com.example.apelsin_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(nativeQuery = true, value = "select * from orders where id not in (select order_id from detail)")
    List<Order> findAllByOrderWithOutDetails();

    @Query(nativeQuery = true,value = "select o.id as id, o.date as date, sum(d.quantity*p.price) as total from orders o\n" +
            "              join detail d on o.id = d.order_id\n" +
            "               join product p on p.id = d.product_id\n" +
            "            where o.id not in (select order_id from invoice)\n" +
            "            group by o.id")
    List<Order> findAllByOrderWithOutInvoice();

}
