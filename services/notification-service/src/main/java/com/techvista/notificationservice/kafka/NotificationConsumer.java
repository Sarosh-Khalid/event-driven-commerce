package com.techvista.notificationservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    @KafkaListener(
            topics = "payment-completed",
            groupId = "notification-group"
    )
    public void consume(PaymentCompletedEvent event) {

        System.out.println("📧 NOTIFICATION SERVICE");

        System.out.println("Order ID: " + event.orderId());
        System.out.println("Amount: " + event.amount());
        System.out.println("Status: " + event.status());

        System.out.println("Email sent successfully ✅");
    }
}