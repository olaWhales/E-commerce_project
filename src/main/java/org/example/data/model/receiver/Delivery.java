package org.example.data.model.receiver;

import jakarta.persistence.*;

import lombok.Data;
import org.example.data.model.goods.Address;

@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String item ;
    private String deliveryDate ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address deliveryAddress;
}
