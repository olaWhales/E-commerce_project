package org.example.data.model.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String firstName ;
    private String lastName ;
    private String contact ;
    private String email ;
    private LocalDate birthDate ;
    private LocalDateTime dateCreated;
    private String password ;

}
