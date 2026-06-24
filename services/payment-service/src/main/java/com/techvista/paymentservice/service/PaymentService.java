package com.techvista.paymentservice.service;


import com.techvista.paymentservice.kafka.InventoryUpdatedEvent;


public interface PaymentService {


    void processPayment(
            InventoryUpdatedEvent event
    );

}