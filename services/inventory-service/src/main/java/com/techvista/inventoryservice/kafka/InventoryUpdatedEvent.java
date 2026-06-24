package com.techvista.inventoryservice.kafka;


public record InventoryUpdatedEvent(

        Long orderId,

        Long productId,

        Integer quantity,

        boolean available

) {}