package org.example.data.model.user;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@DiscriminatorValue("Buyer")
public class Buyer extends Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String Address ;
}
