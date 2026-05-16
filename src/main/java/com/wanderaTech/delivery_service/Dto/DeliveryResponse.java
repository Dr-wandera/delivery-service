package com.wanderaTech.delivery_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private String deliveryId;
    private String pickingPointContact;
    private String deliveryAddress;
    private String pickingPointDescription;
    private String pickingPointEmail;
    private String productId;
    private LocalDateTime createAt;
}
