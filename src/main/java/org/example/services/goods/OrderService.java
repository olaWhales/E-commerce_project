package org.example.services.goods;

import org.example.dto.request.goodsRequest.OrderRequest;
import org.example.dto.respond.goodsResponse.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse updateOrder(OrderRequest orderRequest);
    OrderResponse cancelOrder(OrderRequest orderRequest, String orderId);
}
