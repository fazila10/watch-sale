package com.accenture.imaginea.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryInputDto {
    Integer productId;
    Integer totalNumber;
    Integer stockAvailable;
}
