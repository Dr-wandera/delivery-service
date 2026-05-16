package com.wanderaTech.delivery_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequest {
    private String pickingPointContact;
    private String sellerId;
    private String deliveryAddress;
    private String pickingPointDescription;
    private String pickingPointEmail;
    private String productId;

}
