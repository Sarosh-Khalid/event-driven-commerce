package com.techvista.inventoryservice.service;


import com.techvista.inventoryservice.entity.Inventory;
import com.techvista.inventoryservice.repository.InventoryRepository;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class InventoryServiceImpl
        implements InventoryService {



    private final InventoryRepository repository;



    @Override
    public void processOrder(
            Long productId,
            Integer quantity) {



        Inventory inventory =
                repository.findByProductId(productId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Inventory not found"
                                )
                        );



        if(inventory.getAvailableQuantity()
                < quantity){


            throw new RuntimeException(
                    "Insufficient stock"
            );

        }



        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity()
                        - quantity
        );


        repository.save(inventory);



        System.out.println(
                "Inventory updated"
        );


    }

}