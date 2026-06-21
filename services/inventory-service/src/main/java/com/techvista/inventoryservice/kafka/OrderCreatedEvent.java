package com.techvista.inventoryservice.kafka;


public record OrderCreatedEvent(

        Long orderId,

        Long userId,

        Long productId,

        Integer quantity

) {}