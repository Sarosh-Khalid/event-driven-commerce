package com.techvista.paymentservice.service;


import com.techvista.paymentservice.entity.Payment;
import com.techvista.paymentservice.kafka.InventoryUpdatedEvent;


public interface PaymentService {


    Payment processPayment(
            InventoryUpdatedEvent event
    );

}