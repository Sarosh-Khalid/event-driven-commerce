package com.techvista.orderservice.service;


import com.techvista.orderservice.dto.CreateOrderRequest;
import com.techvista.orderservice.entity.Order;


public interface OrderService {


    Order create(
            CreateOrderRequest request
    );
}