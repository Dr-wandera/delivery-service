package com.wanderaTech.delivery_service.service;

import com.wanderaTech.delivery_service.Dto.DeliveryRequest;
import com.wanderaTech.delivery_service.Dto.DeliveryResponse;

public interface DeliveryServiceInterface {
    DeliveryResponse placeDeliveryToCustomer(DeliveryRequest deliveryRequest);

    DeliveryResponse getDeliveryDetails(String deliveryId);

    DeliveryResponse updateDelivery(String deliveryId, DeliveryRequest deliveryRequest);
}
