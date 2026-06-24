package com.techvista.inventoryservice.kafka;


import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class InventoryEventProducer {


    private final KafkaTemplate<String, InventoryUpdatedEvent>
            kafka;



    public void publish(
            InventoryUpdatedEvent event){


        kafka.send(
                "inventory-updated",
                event
        );

    }

}