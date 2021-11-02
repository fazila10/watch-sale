package com.accenture.imaginea.mapper;

import com.accenture.imaginea.dto.OrderDto;
import com.accenture.imaginea.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mappings({
            @Mapping(target="orderId", source="order.orderId"),
            @Mapping(target="total", source="order.total"),
            @Mapping(target="productDto", source="order.product"),
            @Mapping(target="registrationDto", source="order.registration")
    })
    OrderDto entityToDto(Order order);
    @Mappings({
            @Mapping(target="orderId", source="orderDto.orderId"),
            @Mapping(target="total", source="orderDto.total"),
            @Mapping(target="product", source="orderDto.productDto"),
            @Mapping(target="registration", source="orderDto.registrationDto")
    })
    Order dtoToEntity(OrderDto orderDto);
}
