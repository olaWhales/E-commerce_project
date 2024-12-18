package org.example.dto.request.goodsRequest;

import lombok.Data;
import org.example.data.model.goods.Address;
import org.example.data.model.goods.OrderStatus;
import org.example.data.model.goods.Product;
import org.example.data.model.user.Buyer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    private Address address ;
    private LocalDateTime orderDate;
    private LocalDate deliveryDate;
    private OrderStatus orderStatus;
    private Long buyer ;
    private Long productId ;

}
