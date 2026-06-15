package com.techvista.productservice.repository;


import com.techvista.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository
        extends JpaRepository<Product, Long> {


}