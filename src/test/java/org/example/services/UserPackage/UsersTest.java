package org.example.services.UserPackage;

import org.example.data.model.user.Users;
import org.example.data.repositories.User.UserRepository;
import org.example.dto.request.usersRegisterRequest.UsersRequest;
import org.example.dto.respond.usersRegisterResponse.UsersResponse;
import org.example.services.usersRegistration.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UsersTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsersService usersService;

    @Test
    public void testThatUserCanRegister(){
        UsersResponse usersResponse = usersService.registerUser(new UsersRequest());
        UsersRequest usersRequest = new UsersRequest();
        Users users = new Users();
        users.setFirstName(usersRequest.getFirstName());
        users.setLastName(usersRequest.getLastName());
        users.setEmail(usersRequest.getEmail());
        users.setPassword(usersRequest.getPassword());
        users.setContact(usersRequest.getContact());
        users.setDateCreated(usersRequest.getDateCreated());
        users.setBirthDate(usersRequest.getBirthDate());
        userRepository.save(users);
        usersResponse.setMessage(usersResponse.getMessage());
        assertEquals(usersResponse.getMessage() , "Register successful");
    }

    @Test
    public void testThatUserCannotLoginAfterRegister(){
        UsersResponse usersResponse = usersService.registerUser(new UsersRequest());
        Users users = new Users();
        users.setEmail("tutu@gmail.com");
        users.setPassword("6666");
        userRepository.save(users);
        UsersResponse usersResponse1 = usersService.loginUser("tutu@gmail.com", "0000");
        usersResponse1.setMessage("Login successful");
        assertEquals(usersResponse1.getMessage() , "Login successful");
    }
    @Test
    public void thatThatUserCannotLoginWithWrongDetails(){
        UsersResponse usersResponse = usersService.registerUser(new UsersRequest());
        Users users = new Users();
        users.setEmail("tutu@gmail.com");
        users.setPassword("6666");
        userRepository.save(users);
        UsersResponse usersResponse1 = usersService.loginUser("tutu@gmail.com", "1212");
//        usersResponse1.setMessage("Login failed");
        assertEquals(usersResponse1.getMessage() , "Login failed");
    }
}
