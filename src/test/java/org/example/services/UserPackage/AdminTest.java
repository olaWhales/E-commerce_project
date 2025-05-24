package org.example.services.UserPackage;

import org.example.data.model.user.Admin;
import org.example.data.repositories.User.AdminRepository;
import org.example.dto.request.usersRegisterRequest.AdminRequest;
import org.example.dto.respond.usersRegisterResponse.AdminResponse;
import org.example.services.usersRegistration.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class AdminTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testThatAdminCanRegister() {
        AdminResponse adminResponse = adminService.adminRegister(new AdminRequest());
        AdminRequest adminRequest = new AdminRequest();
        Admin admin = new Admin();
        adminRequest.setFirstName("ola");
        adminRequest.setLastName("ola");
        adminRequest.setEmail("ajadi@gmail.com");
        adminRequest.setPassword("1111");
        adminRequest.setContact("090");
        adminRequest.setDateCreated(LocalDateTime.now());
        adminRequest.setPermission("access");
        adminRequest.setRoles("Driver");
        adminRequest.setBirthDate(LocalDate.ofEpochDay(2002-10-10));
//        admin.setFirstName(adminRequest.getFirstName());
//        admin.setLastName(adminRequest.getLastName());
//        admin.setEmail(adminRequest.getEmail());
//        admin.setPassword(adminRequest.getPassword());
//        admin.setContact(adminRequest.getContact());
//        admin.setBirthDate(adminRequest.getBirthDate());
//        admin.setDateCreated(adminRequest.getDateCreated());
//        admin.setRoles(adminRequest.getRoles());
//        admin.setPermission(adminRequest.getPermission());
        adminRepository.save(admin);
        adminResponse.setMessage("You have successfully registered!");
        assertEquals(adminResponse.getMessage(), "You have successfully registered!");
    }

    @Test
    public void testThatAdminCanLoginAfterRegister() {
        AdminResponse adminResponse = adminService.adminRegister(new AdminRequest());
        AdminRequest adminRequest = new AdminRequest();
        Admin admin = new Admin();
        admin.setEmail("ajadi@gmail.com");
        admin.setPassword("1111");
        adminRepository.save(admin);
        adminResponse.setMessage("You have successfully registered!");
        AdminResponse adminResponse1 = adminService.adminLogin("ajadi@gmail.com", "1111");
        assertEquals(adminResponse1.getMessage(), "You have successfully logged in!");
    }

    @Test
    public void testThatAdminCanLoginWithWrongPassword() {
        AdminResponse adminResponse = adminService.adminRegister(new AdminRequest());
        AdminRequest adminRequest = new AdminRequest();
        Admin admin = new Admin();
        admin.setEmail("ajadi@gmail.com");
        admin.setPassword("1111");
        adminRepository.save(admin);
        adminResponse.setMessage("You have successfully registered!");
        AdminResponse adminResponse1 = adminService.adminLogin("ajadi@gmail.com", "2233");
        assertEquals(adminResponse1.getMessage(), "Your account doesn't exist!");
    }
}
