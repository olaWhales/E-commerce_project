package org.example.data.model.goods;

import jakarta.persistence.*;
import lombok.Data;
import org.example.data.model.user.Buyer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate deliveryDate ;
    private LocalDateTime orderTime ;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus ;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id" )
    private Address address ;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyerId ;

    @ManyToMany
    @JoinTable(
            name = "order_product", // the name of the join table
            joinColumns = @JoinColumn(name = "order_id"), // the foreign key to the order table
            inverseJoinColumns = @JoinColumn(name = "product_id") // the foreign key to the product table
    )
    private List<Product> products;
}
