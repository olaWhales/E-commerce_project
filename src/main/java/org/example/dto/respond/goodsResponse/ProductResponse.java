package org.example.dto.respond.goodsResponse;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String message;
    private String productName;
    private String productDescription;
    private double productPrice;
    private Integer productQuantity;
}
