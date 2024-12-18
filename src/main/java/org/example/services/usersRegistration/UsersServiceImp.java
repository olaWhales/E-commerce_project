package org.example.services.usersRegistration;

import org.example.data.model.user.Users;
import org.example.data.repositories.User.UserRepository;
import org.example.dto.request.usersRegisterRequest.UsersRequest;
import org.example.dto.respond.usersRegisterResponse.AdminResponse;
import org.example.dto.respond.usersRegisterResponse.UsersResponse;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UsersService {
    private final UserRepository userRepository;

    public UsersServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UsersResponse registerUser(UsersRequest usersRequest) {
        Users user = new Users();
        user.setFirstName(usersRequest.getFirstName());
        user.setLastName(usersRequest.getLastName());
        user.setEmail(usersRequest.getEmail());
        user.setPassword(usersRequest.getPassword());
        user.setContact(usersRequest.getContact());
        user.setBirthDate(usersRequest.getBirthDate());
        user.setDateCreated(usersRequest.getDateCreated());
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setMessage("Register successful");
        return usersResponse;
    }

    @Override
    public UsersResponse loginUser(String email, String password) {
        UsersResponse usersResponse = new UsersResponse();
        if(userRepository.findByEmailAndPassword(email , password).isPresent()) {
            usersResponse.setMessage("Login successful");
        }else{
            usersResponse.setMessage("Login failed");
        }
        return usersResponse;
    }


}
