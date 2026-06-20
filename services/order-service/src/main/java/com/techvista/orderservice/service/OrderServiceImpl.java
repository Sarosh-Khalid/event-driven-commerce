package com.techvista.orderservice.service;


import com.techvista.orderservice.dto.*;
import com.techvista.orderservice.entity.Order;
import com.techvista.orderservice.kafka.*;

import com.techvista.orderservice.repository.OrderRepository;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDateTime;



@Service
@RequiredArgsConstructor
public class OrderServiceImpl
        implements OrderService {



    private final OrderRepository repository;

    private final OrderEventProducer producer;



    @Override
    public Order create(
            CreateOrderRequest request) {


        Order order =
                Order.builder()
                        .userId(request.userId())
                        .productId(request.productId())
                        .quantity(request.quantity())
                        .totalAmount(
                                BigDecimal.valueOf(0)
                        )
                        .status("CREATED")
                        .createdAt(
                                LocalDateTime.now()
                        )
                        .build();



        Order saved =
                repository.save(order);



        producer.publish(
                new OrderCreatedEvent(
                        saved.getId(),
                        saved.getUserId(),
                        saved.getProductId(),
                        saved.getQuantity(),
                        saved.getTotalAmount()
                )
        );



        return saved;

    }

}