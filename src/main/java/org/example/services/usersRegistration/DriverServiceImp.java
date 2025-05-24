package org.example.services.usersRegistration;

import org.example.data.model.user.Driver;
import org.example.data.repositories.User.DriverRepository;
import org.example.dto.request.usersRegisterRequest.DriverRequest;
import org.example.dto.request.transitRequest.VehicleRequest;
import org.example.dto.respond.transitResponse.DriverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements DriverService {

//    @Autowired
    private final DriverRepository driverRepository;

    public DriverServiceImp(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    @Autowired
    private VehicleRequest vehicleRequest;


    @Override
    public DriverResponse driverRegister(DriverRequest driverRequest) {
        Driver driver = new Driver();
        driver.setFirstName(driverRequest.getFirstName());
        driver.setLastName(driverRequest.getLastName());
        driver.setBirthDate(driverRequest.getBirthDate());
        driver.setEmail(driverRequest.getEmail());
        driver.setContact(driverRequest.getContact());
        driver.setDateCreated(driverRequest.getDateCreated());
        driver.setPassword(driverRequest.getPassword());
        driverRepository.save(driver);
        DriverResponse driverResponse = new DriverResponse();
        driverRepository.save(driver);
        Long driverId = driver.getId();
        driverResponse.setMessage("You have successfully registered"  + driverId);
        return driverResponse;
    }

    @Override
    public DriverResponse driverLogin(String email, String password) {
        DriverResponse driverResponse = new DriverResponse();
        if(driverRepository.findByEmailAndPassword(email , password).isPresent()) {
            driverResponse.setMessage("You have successfully login" );
        }else{
            driverResponse.setMessage("Your details are not correct");
        }
        return driverResponse;
    }

}
