package org.example.services.usersRegistration;

import org.example.dto.request.usersRegisterRequest.SellerRequest;
import org.example.dto.respond.usersRegisterResponse.SellerResponse;

public interface SellerService {
    SellerResponse sellerRegister(SellerRequest sellerRequest);
    SellerResponse sellerLogin(String Email, String Password);
}
