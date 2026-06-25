package com.techvista.paymentservice.kafka;


import com.techvista.paymentservice.entity.Payment;
import com.techvista.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class InventoryConsumer {


    private final PaymentService service;

    private final KafkaTemplate<String, PaymentCompletedEvent> kafka;

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


        Payment payment = service.processPayment(event);

        kafka.send(
                "payment-completed",
                new PaymentCompletedEvent(
                        payment.getOrderId(),
                        payment.getAmount(),
                        payment.getStatus()
                )
        );


    }

}