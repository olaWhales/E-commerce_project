package org.example.dto.request.goodsRequest;

import lombok.Data;

@Data
public class ProductRequest {
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private Integer productQuantity;
    private Long sellerId;
}
