package com.accenture.imaginea.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private int orderId;
    private RegistrationDto registrationDto;
    private ProductDto productDto;
    private double total;
}
