package org.example.services.transit;

import org.example.data.model.user.Driver;
import org.example.data.model.transit.Vehicles;
import org.example.data.repositories.User.DriverRepository;
import org.example.data.repositories.transit.VehicleRepository;
import org.example.dto.request.usersRegisterRequest.DriverRequest;
import org.example.dto.request.transitRequest.VehicleRequest;
import org.example.dto.respond.transitResponse.DriverResponse;
import org.example.dto.respond.transitResponse.VehicleResponse;
import org.example.services.usersRegistration.DriverServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.lang.classfile.constantpool.IntegerEntry;

@Service
public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverServiceImp driverServiceImp;

    @Transactional
    @Override
    public VehicleResponse vehicleResponse(VehicleRequest vehicleRequest) {
        DriverResponse request = driverServiceImp.driverRegister(new DriverRequest());
        DriverRequest driverRequest = new DriverRequest();
        Driver driver = new Driver();
        if (driverRepository.existsById(driver.getId())) {
            driverRequest.setDriverLicenseNumber(driverRequest.getDriverLicenseNumber());
            driverRequest.setFirstName(driverRequest.getFirstName());
            driverRequest.setLastName(driverRequest.getLastName());
        }else
            if (!driverRepository.existsById(driver.getId())) {
//                for (Driver driver1 : driverRepository.findAll()) {
//                    if (driver1.getId().equals(driver.getId())) {
//                        driver = driver1;
//                        break;
//                    }
//                }
                driver.setFirstName(driverRequest.getFirstName());
                driver.setLastName(driverRequest.getLastName());
//                driver.setDriverLicenseNumber(driverRequest.getDriverLicenseNumber());
                vehicleRequest.setDriver(driver);
                driverRepository.save(driver);
            } else throw new IllegalArgumentException("Driver already exists");
            Vehicles vehicle = getVehicles(vehicleRequest);
            vehicle.setDriver(driver);
            vehicle.setVehicleType(vehicleRequest.getVehicleType());
            vehicle.setCapacity(vehicleRequest.getCapacity());
            vehicle.setLicensePlateNumber(vehicleRequest.getLicensePlate());
        vehicle.setId(driver.getId());
            vehicleRepository.save(vehicle);
            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setMessage(vehicle.getDriver() + " You have successfully registered for a vehicle ");
            return vehicleResponse;
            }

    private static Vehicles getVehicles(VehicleRequest vehicleRequest) {
        Vehicles vehicle = new Vehicles();
        vehicle.setVehicleType(vehicleRequest.getVehicleType());
        vehicle.setLicensePlateNumber(vehicleRequest.getLicensePlate());
        vehicle.setCapacity(vehicleRequest.getCapacity());

//        vehicle.set;

        return vehicle;
    }
}
