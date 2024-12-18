package org.example.dto.respond.goodsResponse;

import lombok.Data;
import org.example.data.model.goods.Order;
import org.example.data.model.goods.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Order orderId;
    private OrderStatus orderStatus;
    private String message ;
    private Long buyerId ;
    private LocalDate deliveryDate ;
    private LocalDateTime orderDate ;
}
