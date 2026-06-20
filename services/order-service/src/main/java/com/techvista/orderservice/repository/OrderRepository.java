package com.techvista.orderservice.repository;


import com.techvista.orderservice.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository
        extends JpaRepository<Order,Long> {

}