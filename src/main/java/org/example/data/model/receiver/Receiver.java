package org.example.data.model.receiver;

import jakarta.persistence.*;
import lombok.Data;
import org.example.data.model.goods.Address;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String phoneNumber ;

    @OneToMany( cascade = CascadeType.PERSIST)
    private List <Delivery> receiverDeliveries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address ;
}
