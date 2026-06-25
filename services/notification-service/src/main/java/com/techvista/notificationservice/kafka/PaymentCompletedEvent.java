package com.techvista.notificationservice.kafka;

import java.math.BigDecimal;

public record PaymentCompletedEvent(

        Long orderId,
        BigDecimal amount,
        String status

) {}