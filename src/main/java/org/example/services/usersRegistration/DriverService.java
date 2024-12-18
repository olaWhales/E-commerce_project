package org.example.services.usersRegistration;

import org.example.dto.request.usersRegisterRequest.DriverRequest;
import org.example.dto.respond.transitResponse.DriverResponse;

public interface DriverService {
//    DriverResponse driverResponse(DriverRequest driverRequest);

    DriverResponse driverRegister(DriverRequest driverRequest);

    DriverResponse driverLogin(String email, String password);
}
