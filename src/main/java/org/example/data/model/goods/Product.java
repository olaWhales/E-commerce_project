package org.example.data.model.goods;

import jakarta.persistence.*;
import lombok.Data;
import org.example.data.model.user.Seller;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productDescription;
    private double productPrice;
    private Integer productQuantity;

    @ManyToOne
    @JoinColumn (name = "seller_id")
    private Seller seller;
}
