package com.wanderaTech.delivery_service.Repository;

import com.wanderaTech.delivery_service.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByProductId(String productId);

    Optional<Delivery> findByDeliveryId(String deliveryId);
}
