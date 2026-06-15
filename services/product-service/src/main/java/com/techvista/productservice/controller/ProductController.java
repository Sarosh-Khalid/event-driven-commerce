package com.techvista.productservice.controller;


import com.techvista.productservice.dto.*;

import com.techvista.productservice.service.ProductService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;



    @PostMapping
    public ProductResponse create(
            @Valid
            @RequestBody ProductRequest request) {

        return service.create(request);
    }



    @GetMapping
    public List<ProductResponse> getAll(){

        return service.findAll();
    }



    @GetMapping("/{id}")
    public ProductResponse getOne(
            @PathVariable Long id){

        return service.findById(id);
    }



    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id){

        service.delete(id);
    }
}