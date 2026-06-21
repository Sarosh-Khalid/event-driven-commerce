package com.techvista.inventoryservice.service;


public interface InventoryService {


    void processOrder(
            Long productId,
            Integer quantity
    );

}