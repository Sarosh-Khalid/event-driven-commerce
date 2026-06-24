package com.techvista.paymentservice.kafka;


import com.techvista.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class InventoryConsumer {


    private final PaymentService service;



    @KafkaListener(
            topics="inventory-updated",
            groupId="payment-group"
    )
    public void consume(
            InventoryUpdatedEvent event
    ){


        System.out.println(
                "Inventory event received "
                        + event.orderId()
        );


        service.processPayment(event);


    }

}