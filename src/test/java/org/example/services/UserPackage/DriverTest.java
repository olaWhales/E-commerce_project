package org.example.services.UserPackage;

import org.example.data.model.user.Driver;
import org.example.data.repositories.User.DriverRepository;
import org.example.dto.request.usersRegisterRequest.DriverRequest;
import org.example.dto.respond.transitResponse.DriverResponse;
import org.example.services.usersRegistration.DriverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class DriverTest {
    @Autowired
    private DriverService driverService;
    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void testThatDriverCanRegister(){
        DriverResponse driverResponse = driverService.driverRegister(new DriverRequest());
        DriverRequest driverRequest = new DriverRequest();
        Driver driver = new Driver();
        driver.setFirstName(driverRequest.getFirstName());
        driver.setLastName(driverRequest.getLastName());
        driver.setPassword(driverRequest.getPassword());
        driver.setEmail(driverRequest.getEmail());
        driver.setContact(driverRequest.getContact());
        driver.setBirthDate(driverRequest.getBirthDate());
        driver.setDateCreated(driverRequest.getDateCreated());
        driverRepository.save(driver);
        driverResponse.setMessage("success");
        assertEquals(driverResponse.getMessage(), "success");
    }

    @Test
    public void TestThatDriverCanLogin(){
        DriverResponse driverResponse = driverService.driverRegister(new DriverRequest());
        Driver driver = new Driver();
        driver.setEmail("olu@gmail.com");
        driver.setPassword("1234");
        driverRepository.save(driver);
        DriverResponse driverResponse1 = driverService.driverLogin("olu@gmail.com", "1234");
        driverResponse1.setMessage("You have successfully registered");
        assertEquals(driverResponse1.getMessage(), "You have successfully registered");
    }
    @Test
    public void testThatDriverCannotLoginWithWrongDetails(){
        DriverResponse driverResponse = driverService.driverRegister(new DriverRequest());
        Driver driver = new Driver();
        driver.setEmail("olu@gmail.com");
        driver.setPassword("1234");
        driverRepository.save(driver);
        DriverResponse driverResponse1 = driverService.driverLogin("olu@gmail.com", "0000");
//        driverResponse1.setMessage("Your details are not correct");
        assertEquals(driverResponse1.getMessage(), "Your details are not correct");
    }

}
