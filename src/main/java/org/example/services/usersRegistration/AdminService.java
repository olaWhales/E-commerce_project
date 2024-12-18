package org.example.services.usersRegistration;

import org.example.dto.request.usersRegisterRequest.AdminRequest;
import org.example.dto.respond.usersRegisterResponse.AdminResponse;

public interface AdminService {
    AdminResponse adminRegister(AdminRequest adminRequest);
    AdminResponse adminLogin(String email, String password);
//    AdminResponse adminChangePassword(String oldPassword);
}
