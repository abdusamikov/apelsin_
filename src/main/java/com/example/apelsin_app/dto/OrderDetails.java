package com.example.apelsin_app.dto;

import com.example.apelsin_app.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    private Order order;
    private List<DetailsDto> details;
}
