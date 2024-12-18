package org.example.data.model.transit;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;
import org.example.data.model.user.Driver;
//import javax.persistence.*;

@Entity
@Data
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String licensePlateNumber ;
    private String capacity ;
    private String vehicleType ;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver ;
}
