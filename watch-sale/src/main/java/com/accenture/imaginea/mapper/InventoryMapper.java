package com.accenture.imaginea.mapper;

import com.accenture.imaginea.dto.InventoryDto;
import com.accenture.imaginea.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    @Mappings({
            @Mapping(target="inventoryId", source="inventory.inventoryId"),
            @Mapping(target="totalNumber", source="inventory.totalNumber"),
            @Mapping(target="stockAvailable", source="inventory.stockAvailable"),
            @Mapping(target="productDto", source="inventory.product")
    })
    InventoryDto entityToDto(Inventory inventory);
    @Mappings({
            @Mapping(target="inventoryId", source="inventoryDto.inventoryId"),
            @Mapping(target="totalNumber", source="inventoryDto.totalNumber"),
            @Mapping(target="stockAvailable", source="inventoryDto.stockAvailable"),
            @Mapping(target="product", source="inventoryDto.productDto")
    })
    Inventory dtoToEntity(InventoryDto inventoryDto);
}
