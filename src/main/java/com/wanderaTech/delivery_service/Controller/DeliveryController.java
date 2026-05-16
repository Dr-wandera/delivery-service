package com.wanderaTech.delivery_service.Controller;

import com.wanderaTech.delivery_service.Dto.DeliveryRequest;
import com.wanderaTech.delivery_service.Dto.DeliveryResponse;
import com.wanderaTech.delivery_service.service.DeliveryServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/seller/delivery")
public class DeliveryController {
    private final DeliveryServiceImplementation deliveryServiceImplementation;

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponse placeDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        return deliveryServiceImplementation.placeDeliveryToCustomer(deliveryRequest);
    }

    @GetMapping("/get/{deliveryId})")
    @ResponseStatus(HttpStatus.OK)
    public  DeliveryResponse deliveryToCustomer(@PathVariable String deliveryId) {
        return deliveryServiceImplementation.getDeliveryDetails(deliveryId);
    }
    @PutMapping("/update/{deliveryId}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryResponse updateDelivery(@PathVariable String deliveryId, @RequestBody DeliveryRequest deliveryRequest) {
        return deliveryServiceImplementation.updateDelivery(deliveryId,deliveryRequest);
    }
}
