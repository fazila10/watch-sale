package com.accenture.imaginea.mapper;

import com.accenture.imaginea.dto.ProductDto;
import com.accenture.imaginea.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto entityToDto(Product product);
    Product dtoToEntity(ProductDto productDto);
}
