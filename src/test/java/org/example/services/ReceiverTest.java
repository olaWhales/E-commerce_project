package org.example.services;

import org.example.data.repositories.receiver.AddressRepository;
import org.example.data.repositories.receiver.DeliveryRepository;
import org.example.data.repositories.receiver.ReceiverRepository;
import org.example.dto.request.receiverRequest.AddressRequest;
import org.example.dto.request.receiverRequest.DeliveryRequest;
import org.example.dto.request.receiverRequest.ReceiverRequest;
import org.example.services.receivers.ReceiverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class ReceiverTest {
    @Autowired
    ReceiverService receiverService;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void testThatReceiverServiceWorks() {
         ReceiverRequest receiverRequest = new ReceiverRequest();
            receiverRequest.setName("ajoke");
            receiverRequest.setPhoneNumber("08102791111");
            DeliveryRequest deliveryRequest = new DeliveryRequest();
            deliveryRequest.setItem("Jollof Rice");
            deliveryRequest.setDeliveryDate(String.valueOf(LocalDate.now()));
            AddressRequest addressRequest = new AddressRequest();
            addressRequest.setCity("America");
            addressRequest.setStreet("California");
            deliveryRequest.setAddress(addressRequest);
            receiverRequest.setDelivery(Collections.singletonList(deliveryRequest));

            ReceiverRequest response = receiverService.receiver(receiverRequest);

            assertEquals("ajoke", response.getName());
            assertEquals("08102791111", response.getPhoneNumber());

            assertNotNull(response.getDelivery());
            assertEquals(1, response.getDelivery().size());
            DeliveryRequest savedDeliveryRequest = response.getDelivery().get(0);

            assertEquals("Jollof Rice", savedDeliveryRequest.getItem());
            assertEquals(String.valueOf(LocalDate.now()), savedDeliveryRequest.getDeliveryDate());
            assertEquals("America", savedDeliveryRequest.getAddress().getCity());
            assertEquals("California", savedDeliveryRequest.getAddress().getStreet());
        }
    }

