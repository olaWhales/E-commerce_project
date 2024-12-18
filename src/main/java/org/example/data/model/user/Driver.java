package org.example.data.model.user;

import jakarta.persistence.*;
import lombok.Data;
import org.example.data.model.transit.Vehicles;

import java.util.List;

@Entity
@DiscriminatorValue("Driver")
public class Driver extends Users {

    private String driverLicenseNumber ;

    @OneToMany
    @JoinColumn(name = "vehicle_id")
    private List<Vehicles> vehicle;
}
