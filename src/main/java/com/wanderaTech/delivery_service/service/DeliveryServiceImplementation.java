package com.wanderaTech.delivery_service.service;

import com.wanderaTech.delivery_service.Dto.DeliveryRequest;
import com.wanderaTech.delivery_service.Dto.DeliveryResponse;
import com.wanderaTech.delivery_service.Model.Delivery;
import com.wanderaTech.delivery_service.Repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImplementation implements DeliveryServiceInterface{
    private final DeliveryRepository deliveryRepository;;

    //initiate delivery of product bought by customer to customer
    @Override
    public DeliveryResponse placeDeliveryToCustomer(DeliveryRequest deliveryRequest) {
        Delivery delivery=deliveryRepository.findByProductId(deliveryRequest.getProductId())
                .orElseThrow(()->new RuntimeException(
                        "Product with productId: "+deliveryRequest.getProductId()+" already on delivery")
                );
        Delivery entity=toEntity(deliveryRequest);
        var saveDelivery = deliveryRepository.save(entity);
        return toResponse(saveDelivery);


    }

    //get delivery by id
    @Override
    public DeliveryResponse getDeliveryDetails(String deliveryId) {
        Delivery delivery=deliveryRepository.findByDeliveryId(deliveryId)
                .orElseThrow(()->new RuntimeException("Delivery with Id is not Available in the server"));
        return  toResponse(delivery);
    }

    //update delivery
    @Override
    public DeliveryResponse updateDelivery(String deliveryId, DeliveryRequest deliveryRequest) {
        Delivery delivery=deliveryRepository.findByDeliveryId(deliveryId)
                .orElseThrow(()->new RuntimeException("Delivery with Id is not Available in the server"));

        if (Objects.nonNull(delivery.getDeliveryAddress())&&"".equals(delivery.getDeliveryAddress()))
            delivery.setDeliveryAddress(deliveryRequest.getDeliveryAddress());
        if (Objects.nonNull(delivery.getPickingPointContact())&&"".equals(delivery.getPickingPointContact()))
            delivery.setPickingPointContact(deliveryRequest.getPickingPointContact());
        if (Objects.nonNull(delivery.getPickingPointDescription())&&"".equals(delivery.getPickingPointDescription()))
            delivery.setPickingPointDescription(deliveryRequest.getPickingPointDescription());
        if(Objects.nonNull(delivery.getPickingPointEmail())&&"".equals(delivery.getPickingPointEmail()))
            delivery.setPickingPointEmail(deliveryRequest.getPickingPointEmail());

        var updatedDelivery=deliveryRepository.save(delivery);

        return toResponse(updatedDelivery);
    }

    //convert entity->response
    private DeliveryResponse toResponse(Delivery saveDelivery) {
        DeliveryResponse response=new DeliveryResponse();
        response.setDeliveryId(saveDelivery.getDeliveryId());
        response.setProductId(saveDelivery.getProductId());
        response.setDeliveryAddress(saveDelivery.getDeliveryAddress());
        response.setPickingPointEmail(saveDelivery.getPickingPointEmail());
        response.setPickingPointDescription(saveDelivery.getPickingPointDescription());
        response.setCreateAt(LocalDateTime.now());
        return response;
    }

    //convert dto->entity
    private Delivery toEntity(DeliveryRequest deliveryRequest) {
       return Delivery.builder()
                .productId(deliveryRequest.getProductId())
                .sellerId(deliveryRequest.getSellerId())
                .deliveryId(generateDeliveryId())
                .deliveryAddress(deliveryRequest.getDeliveryAddress())
//                .customerId()// TODO to fetch customer info from customer service(webclient)
                .pickingPointContact(deliveryRequest.getPickingPointContact())
                .pickingPointEmail(deliveryRequest.getPickingPointEmail())
                .pickingPointDescription(deliveryRequest.getPickingPointDescription())
                .createAt(LocalDateTime.now())
                .build();
    }

    private String generateDeliveryId() {
        String random = UUID.randomUUID().toString();
        return random;
    }
}
