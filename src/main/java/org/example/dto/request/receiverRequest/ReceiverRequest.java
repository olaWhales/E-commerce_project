package org.example.dto.request.receiverRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.data.model.receiver.Delivery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ReceiverRequest {
    private String name ;
    private String phoneNumber ;

//    @JsonProperty("delivery")
    private List<DeliveryRequest> delivery = new ArrayList<>();
}
