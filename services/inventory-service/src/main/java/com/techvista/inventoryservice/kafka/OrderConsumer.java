package com.techvista.inventoryservice.kafka;


import com.techvista.inventoryservice.service.InventoryService;


import lombok.RequiredArgsConstructor;


import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class OrderConsumer {


    private final InventoryService service;



    @KafkaListener(
            topics="order-created",
            groupId="inventory-group"
    )
    public void consume(
            OrderCreatedEvent event
    ){


        System.out.println(
                "Received order: "
                        + event.orderId()
        );



        service.processOrder(
                event.productId(),
                event.quantity(),
                event.orderId()
        );



    }

}