package com.techvista.orderservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name="orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    private Long userId;


    private Long productId;


    private Integer quantity;


    private BigDecimal totalAmount;


    private String status;


    private LocalDateTime createdAt;
}