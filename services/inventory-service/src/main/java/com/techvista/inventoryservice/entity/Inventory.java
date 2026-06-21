package com.techvista.inventoryservice.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="inventory")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    @Column(nullable=false)
    private Long productId;


    @Column(nullable=false)
    private Integer availableQuantity;

}