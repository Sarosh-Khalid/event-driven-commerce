package com.techvista.productservice.service;


import com.techvista.productservice.dto.*;

import java.util.List;


public interface ProductService {


    ProductResponse create(
            ProductRequest request);


    List<ProductResponse> findAll();


    ProductResponse findById(
            Long id);


    void delete(
            Long id);
}