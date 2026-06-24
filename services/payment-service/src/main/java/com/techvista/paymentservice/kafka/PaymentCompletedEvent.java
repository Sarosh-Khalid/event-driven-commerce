package com.techvista.paymentservice.kafka;


import java.math.BigDecimal;


public record PaymentCompletedEvent(

        Long orderId,

        BigDecimal amount,

        String status

){}