package com.accenture.imaginea.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDto {

    private int inventoryId;
    private ProductDto productDto;
    private int totalNumber;
    private int stockAvailable;
}
