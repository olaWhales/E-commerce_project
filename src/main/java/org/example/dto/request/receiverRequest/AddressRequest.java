package org.example.dto.request.receiverRequest;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddressRequest {
    private String street;
    private String city;
    private String houseNumber ;
//    private Address addressRequests;
}
