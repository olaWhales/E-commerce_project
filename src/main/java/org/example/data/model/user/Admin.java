package org.example.data.model.user;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@DiscriminatorValue("Admin")

public class Admin extends Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String roles ;
    private String permission ;
}
