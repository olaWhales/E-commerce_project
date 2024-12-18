package org.example.dto.request.receiverRequest;

import lombok.Data;
import org.example.controller.Valid;

@Data
public class DeliveryRequest {
    private String item ;
    private String deliveryDate ;
//    private Receiver receiver ;
    @Valid
    private AddressRequest address;
}
