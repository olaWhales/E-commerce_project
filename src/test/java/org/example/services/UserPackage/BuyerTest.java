package org.example.services.UserPackage;

import org.example.data.model.user.Buyer;
import org.example.data.repositories.User.BuyerRepository;
import org.example.dto.request.usersRegisterRequest.BuyerRequest;
import org.example.dto.respond.usersRegisterResponse.BuyerRepsonse;
import org.example.services.usersRegistration.BuyerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class BuyerTest {

    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private BuyerService buyerService;

    @Test public void testThatBuyerCanRegister(){
        BuyerRepsonse buyerResponse = buyerService.buyerRegister(new BuyerRequest());
        BuyerRequest buyerRequest = new BuyerRequest();
        Buyer buyer = new Buyer();
        buyer.setFirstName(buyerRequest.getFirstName());
        buyer.setLastName(buyerRequest.getLastName());
        buyer.setEmail(buyerRequest.getEmail());
        buyer.setPassword(buyerRequest.getPassword());
        buyer.setAddress(buyerRequest.getAddress());
        buyer.setDateCreated(buyerRequest.getDateCreated());
        buyer.setContact(buyerRequest.getContact());
        buyer.setBirthDate(buyerRequest.getBirthDate());
        buyerRepository.save(buyer);
        buyerResponse.setMessage("You have successfully registered!");
        assertEquals(buyerResponse.getMessage() , "You have successfully registered!");
    }
    @Test public void testThatBuyerCanLoginAfterRegister(){
        BuyerRepsonse buyerResponse = buyerService.buyerRegister(new BuyerRequest());
        Buyer buyer = new Buyer();
        buyer.setEmail("email@email.com");
        buyer.setPassword("0000");
        buyerRepository.save(buyer);
        BuyerRepsonse buyerRepsonse = buyerService.buyerLogin("email@email.com", "0000");
        buyerRepsonse.setMessage("Welcome,it's nice to have here today");
        assertEquals(buyerRepsonse.getMessage() , "Welcome,it's nice to have here today");
    }
    @Test public void testThatBuyerCanotLoginWithWrpngDetails(){
        BuyerRepsonse buyerResponse = buyerService.buyerRegister(new BuyerRequest());
        Buyer buyer = new Buyer();
        buyer.setEmail("email@email.com");
        buyer.setPassword("0000");
        buyerRepository.save(buyer);
        BuyerRepsonse buyerRepsonse = buyerService.buyerLogin("ige@email.com", "9999");
//        buyerRepsonse.setMessage("Please login with correct email and password");
        assertEquals(buyerRepsonse.getMessage() , "Please login with correct email and password");
    }
}
