package com.techvista.inventoryservice.service;


import com.techvista.inventoryservice.entity.Inventory;
import com.techvista.inventoryservice.kafka.InventoryEventProducer;
import com.techvista.inventoryservice.kafka.InventoryUpdatedEvent;
import com.techvista.inventoryservice.repository.InventoryRepository;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class InventoryServiceImpl
        implements InventoryService {



    private final InventoryRepository repository;
    private final InventoryEventProducer producer;



    @Override
    public void processOrder(
            Long productId,
            Integer quantity,
            Long orderId) {


        Inventory inventory =
                repository.findByProductId(productId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Inventory not found")
                        );



        boolean available =
                inventory.getAvailableQuantity()
                        >= quantity;



        if(available){

            inventory.setAvailableQuantity(
                    inventory.getAvailableQuantity()
                            - quantity
            );

            repository.save(inventory);

        }



        producer.publish(

                new InventoryUpdatedEvent(
                        orderId,
                        productId,
                        quantity,
                        available
                )

        );


    }

}