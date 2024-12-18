package org.example.services.receivers;

import org.example.data.model.goods.Address;
import org.example.data.model.receiver.Delivery;
import org.example.data.model.receiver.Receiver;
import org.example.data.repositories.receiver.AddressRepository;
import org.example.data.repositories.receiver.ReceiverRepository;
import org.example.dto.request.receiverRequest.AddressRequest;
import org.example.dto.request.receiverRequest.DeliveryRequest;
import org.example.dto.request.receiverRequest.ReceiverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class receiverServiceImp implements ReceiverService {
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public ReceiverRequest receiver(ReceiverRequest request) {
        Receiver receiver = new Receiver();

        List<Delivery> deliveries = new ArrayList<>();
        AddressRequest request1 = new AddressRequest();
        Address address = new Address();
        address.setCity(request1.getCity());
        address.setStreet(request1.getStreet());
        addressRepository.save(address);

        DeliveryRequest deliveryRequest1 = new DeliveryRequest();
        Delivery delivery = new Delivery();
        delivery.setItem(deliveryRequest1.getItem());
        delivery.setDeliveryDate(deliveryRequest1.getDeliveryDate());
        deliveries.add(delivery);
        delivery.setDeliveryAddress(address);

        receiver.setReceiverDeliveries(deliveries);
        receiver.setName(receiver.getName());
        receiver.setPhoneNumber(receiver.getPhoneNumber());
        receiverRepository.save(receiver);

        return request;
    }
}


