package com.techvista.paymentservice.service;


import com.techvista.paymentservice.entity.Payment;
import com.techvista.paymentservice.kafka.*;

import com.techvista.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Service
@RequiredArgsConstructor
public class PaymentServiceImpl
        implements PaymentService {



    private final PaymentRepository repository;


    @Override
    public void processPayment(
            InventoryUpdatedEvent event) {


        Payment payment =
                Payment.builder()
                        .orderId(event.orderId())
                        .amount(
                                BigDecimal.valueOf(100)
                        )
                        .status(
                                event.available()
                                        ? "SUCCESS"
                                        : "FAILED"
                        )
                        .createdAt(
                                LocalDateTime.now()
                        )
                        .build();



        repository.save(payment);



        System.out.println(
                "Payment processed"
        );


    }

}