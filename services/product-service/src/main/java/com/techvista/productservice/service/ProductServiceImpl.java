package com.techvista.productservice.service;


import com.techvista.productservice.dto.*;
import com.techvista.productservice.entity.Product;
import com.techvista.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl
        implements ProductService {



    private final ProductRepository repository;



    @Override
    public ProductResponse create(
            ProductRequest request) {


        Product product =
                Product.builder()
                        .name(request.name())
                        .description(
                                request.description()
                        )
                        .price(request.price())
                        .category(
                                request.category()
                        )
                        .createdAt(
                                LocalDateTime.now()
                        )
                        .build();


        return map(
                repository.save(product)
        );
    }



    @Override
    @Cacheable(value="allProducts")
    public List<ProductResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }



    @Override
    @Cacheable(
            value = "products",
            key = "#id"
    )
    public ProductResponse findById(Long id) {


        System.out.println(
                "Fetching from database"
        );

        Product product =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Product not found")
                        );


        return map(product);
    }



    @CacheEvict(
            value="products",
            key="#id"
    )
    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }



    private ProductResponse map(
            Product p) {

        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getCategory()
        );
    }
}