package org.example.dto.request.transitRequest;

import lombok.Data;
import org.example.data.model.user.Driver;
import org.springframework.stereotype.Component;

@Component
@Data
public class VehicleRequest {
    private String licensePlate;
    private String capacity ;
    private String vehicleType;

    private Driver driver ;
//    private Driver driverLicenseNumber ;
}
