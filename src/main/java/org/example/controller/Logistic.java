package org.example.controller;

import org.example.dto.request.receiverRequest.ReceiverRequest;
import org.example.dto.request.usersRegisterRequest.DriverRequest;
import org.example.dto.request.transitRequest.VehicleRequest;
import org.example.services.receivers.ReceiverService;
import org.example.services.usersRegistration.DriverService;
import org.example.services.transit.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class Logistic {

    @Autowired
    private ReceiverService receiverService;

    @CrossOrigin(origins = "*")
    @PostMapping("/receiver")
    public ResponseEntity<?> receiver(@Valid @RequestBody ReceiverRequest receiverRequest) {
        try {
            return new ResponseEntity<>(receiverService.receiver(receiverRequest), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>("Database Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Autowired
//    @CrossOrigin(origins = "*")
//    @PostMapping("/productApi/")
//    public ResponseEntity<?>product(@RequestBody ProductRequest productRequest){
//          try{
//            return new ResponseEntity<>(productsService.productResponse(productRequest),CREATED);
//        }catch(Exception exception){
//            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
//        }
//    }


//    @Autowired
//    private SellerService sellerService;
//    @CrossOrigin(origins = "*")
//    @PostMapping("/seller/and/the/productApi/")
//    public ResponseEntity<?> seller(@Valid @RequestBody SellerRequest sellerRequest) {
//        try {
//            return new ResponseEntity<>(sellerService.sellerResponse(sellerRequest), HttpStatus.CREATED);
//        }catch (DataIntegrityViolationException exception){
//            return new ResponseEntity<>("Database Error: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
//        }catch (Exception exception){
//            return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Autowired
    private VehicleService vehicleService ;
    @CrossOrigin(origins = "*")
    @PostMapping("/assign/vehicle/api")
    public ResponseEntity<?> assignVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        try{
            return new ResponseEntity<>(vehicleService.vehicleResponse(vehicleRequest), HttpStatus.CREATED);
        }catch (DataIntegrityViolationException exception){
            return new ResponseEntity<>("Database Error: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception exception){
            return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Autowired
    private DriverService driverService ;
    @CrossOrigin (origins = "*")
    @PostMapping("/driver/api")
    public ResponseEntity<?>driver(@Valid @RequestBody DriverRequest driverRequest) {
        try{
            return new ResponseEntity<>(driverService.driverRegister(new DriverRequest()), HttpStatus.CREATED);
        }catch (DataIntegrityViolationException exception){
            return new ResponseEntity<>("Database Error: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception exception){
            return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
