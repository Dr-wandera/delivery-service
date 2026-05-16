package com.wanderaTech.delivery_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deliveryId;
    private String customerId;// fetched from the order details then get notification of  delivery
    private String sellerId;
    private String pickingPointContact;
    private String deliveryAddress;
    private String pickingPointDescription;
    private String pickingPointEmail;
    private String productId;
    private LocalDateTime createAt;
}
