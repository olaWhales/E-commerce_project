package org.example.data.model.user;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Seller")
public class Seller extends Users {

    private String companyName ;
    private String businessAddress ;
}
