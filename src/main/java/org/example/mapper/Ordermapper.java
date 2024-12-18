package org.example.mapper;

import org.example.data.model.goods.Address;
import org.example.data.model.receiver.Delivery;
import org.example.dto.request.receiverRequest.AddressRequest;
import org.example.dto.request.receiverRequest.DeliveryRequest;
import org.example.dto.request.receiverRequest.ReceiverRequest;
import org.springframework.stereotype.Component;

@Component
public class Ordermapper {

    public void map(ReceiverRequest receiverRequest, AddressRequest addressRequest) {
        Address address = new Address();
        address.setCity(addressRequest.getCity());
        address.setCity(addressRequest.getCity());
    }
    public void map(ReceiverRequest receiverRequest, DeliveryRequest deliveryRequest) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(deliveryRequest.getDeliveryDate());
        delivery.setItem(deliveryRequest.getItem());
//        delivery.setDelieverReceiver(deliveryRequest.getReceiver());
//        delivery.setDeliveryAddress(Address);
    }

//    public Address map(ReceiverRequest receiverResponse, AddressRequest addressRequest) {
//        Address address = new Address();
//        address.setCity(addressRequest.getCity());
//        address.setCity(addressRequest.getCity());
//        return address;
//    }
//    public Delivery map(ReceiverRequest receiverResponse, DeliveryRequest deliveryRequest) {
//        Delivery delivery = new Delivery();
//        delivery.setDeliveryDate(deliveryRequest.getDeliveryDate());
//        delivery.setItem(deliveryRequest.getItem());
//        delivery.setReceiver(deliveryRequest.getReceiver());
//        delivery.setAddress(deliveryRequest.getAddress());
//        return delivery;
//    }



//        public Receiver createRequest(ReceiverRequest receiverResponse) {
//            Receiver receiver = new Receiver();
//            receiver.setName(receiverResponse.getName());
//            receiver.setPhoneNumber(receiverResponse.getPhoneNumber());
//
//            List<Delivery> deliveries = new ArrayList<>();
//            for (DeliveryRequest deliveryRequest : receiverResponse.getDelivery()) {
//                Delivery delivery = new Delivery();
//                delivery.setItem(deliveryRequest.getItem());
//                delivery.setDeliveryDate(deliveryRequest.getDeliveryDate());
//                delivery.setReceiver(receiver);
//
//                Address address = new Address();
//                address.setCity(deliveryRequest.getAddress().getCity());
//                address.setStreet(deliveryRequest.getAddress().getStreet());
//                delivery.setAddress(address);
//
//                deliveries.add(delivery);
//            }
//            receiver.setReceiverDeliveries(deliveries);
//
//            return receiver;
//        }



}
