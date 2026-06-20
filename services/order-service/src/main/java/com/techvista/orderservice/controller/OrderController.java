package com.techvista.orderservice.controller;


import com.techvista.orderservice.dto.CreateOrderRequest;
import com.techvista.orderservice.entity.Order;
import com.techvista.orderservice.service.OrderService;


import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {



    private final OrderService service;



    @PostMapping
    public Order create(
            @Valid
            @RequestBody
            CreateOrderRequest request){

        return service.create(request);
    }


}