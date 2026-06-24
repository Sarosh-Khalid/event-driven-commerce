package com.techvista.paymentservice.kafka;


public record InventoryUpdatedEvent(

        Long orderId,

        Long productId,

        Integer quantity,

        boolean available

){}