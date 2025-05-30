package org.example.services.UserPackage;

import org.example.data.model.user.Seller;
import org.example.data.repositories.User.SellerRepository;
import org.example.dto.request.usersRegisterRequest.SellerRequest;
import org.example.dto.respond.usersRegisterResponse.SellerResponse;
import org.example.services.usersRegistration.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class SellerTest {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerService sellerService;

    @Test
    public void testThatSellerCanRegister(){
        SellerResponse sellerResponse = sellerService.sellerRegister(new SellerRequest());
        SellerRequest sellerRequest = new SellerRequest();
        Seller seller = new Seller();
        seller.setFirstName(sellerRequest.getFirstName());
        seller.setLastName(sellerRequest.getLastName());
        seller.setEmail(sellerRequest.getEmail());
        seller.setPassword(sellerRequest.getPassword());
        seller.setContact(sellerRequest.getContact());
        seller.setDateCreated(sellerRequest.getDateCreated());
        seller.setBirthDate(sellerRequest.getBirthDate());
        sellerRepository.save(seller);
        sellerResponse.setMessage("Register successful");
        assertEquals(sellerResponse.getMessage() , "Register successful");
    }


    @Test
    public void testThatSellerCanLoginAfterRegister(){
        SellerResponse sellerResponse = sellerService.sellerRegister(new SellerRequest());
        Seller seller = new Seller();
        seller.setPassword("3333");
        seller.setEmail("david@gmail.com");
        sellerRepository.save(seller);
        SellerResponse sellerResponse1 = sellerService.sellerLogin("david@gmail.com", "3333");
        sellerResponse.setMessage("Login successful");
        assertEquals(sellerResponse.getMessage() , "Login successful");
    }

    @Test
    public void testThatSellerCanLoginWithWrongPassword(){
        Seller seller = new Seller();
        seller.setPassword("3333");
        seller.setEmail("davids@gmail.com");
        sellerRepository.save(seller);
        SellerResponse sellerResponse1 = sellerService.sellerLogin("david@gmail.com", "3393");
        assertEquals(sellerResponse1.getMessage() , "Login failed");
    }

}
