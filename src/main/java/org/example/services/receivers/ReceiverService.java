package org.example.services.receivers;

import org.example.data.model.receiver.Delivery;
import org.example.dto.request.receiverRequest.ReceiverRequest;
import org.springframework.stereotype.Service;

@Service
public interface ReceiverService {
    ReceiverRequest receiver(ReceiverRequest request);

}
