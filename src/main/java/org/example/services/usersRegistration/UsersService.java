package org.example.services.usersRegistration;

import org.example.dto.request.usersRegisterRequest.UsersRequest;
import org.example.dto.respond.usersRegisterResponse.UsersResponse;

public interface UsersService {
    UsersResponse registerUser(UsersRequest usersRequest);
//    UsersResponse loginUser(UsersRequest usersRequest);

    UsersResponse loginUser(String email, String password);
}
