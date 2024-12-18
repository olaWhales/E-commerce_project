package org.example.services.usersRegistration;

import org.example.dto.request.usersRegisterRequest.BuyerRequest;
import org.example.dto.respond.usersRegisterResponse.BuyerRepsonse;
import org.springframework.stereotype.Service;

@Service
public interface BuyerService {
    BuyerRepsonse buyerRegister(BuyerRequest request);
    BuyerRepsonse buyerLogin(String Email , String password);
}
