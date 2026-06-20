package com.techvista.orderservice.dto;


import jakarta.validation.constraints.NotNull;


public record CreateOrderRequest(

        @NotNull
        Long userId,


        @NotNull
        Long productId,


        @NotNull
        Integer quantity

) {}