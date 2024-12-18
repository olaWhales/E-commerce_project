package org.example.services.transit;

import org.example.dto.request.transitRequest.VehicleRequest;
import org.example.dto.respond.transitResponse.VehicleResponse;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {
    VehicleResponse vehicleResponse(VehicleRequest vehicleRequest);
}
