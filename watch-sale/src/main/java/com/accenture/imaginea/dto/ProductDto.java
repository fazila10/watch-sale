package com.accenture.imaginea.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private int productId;
    private String productName;
    private double price;
}
