package org.example.dto.request.usersRegisterRequest;

import lombok.Data;
import org.example.dto.request.goodsRequest.ProductRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SellerRequest {
    private String firstName ;
    private String lastName ;
    private String contact ;
    private String email ;
    private LocalDate birthDate ;
    private LocalDateTime dateCreated;
    private String password ;
    private String companyName;
    private String businessAddress;

//    private List<ProductRequest> productRequest = new ArrayList<>();
}
