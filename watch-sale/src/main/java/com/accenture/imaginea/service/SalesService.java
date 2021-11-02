package com.accenture.imaginea.service;

import com.accenture.imaginea.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SalesService {

    //Product Table
    List<ProductDto> getAllProducts();
    String addProduct(ProductDto productDto);
    ProductDto updateProduct(Integer productId,ProductDto productDto);
    String deleteProduct(Integer productId);

    //User Table
    String addUser(UserDto userDTO);
    List<UserDto> getAllUsers();

    //Registration Table
    String register(RegistrationInputDto registrationInputDto);
    List<RegistrationDto> getAllRegistrations();

    //Inventory Table
    String addItems(InventoryInputDto inventoryInputDto);
    InventoryDto updateItems(Integer inventoryId, InventoryInputDto inventoryInputDto);
    boolean reduceStock(Integer productId);
    List<InventoryDto> getAllItems();

    //Order Table
    String placeOrder(OrderInputDto orderInputDto);
    List<OrderDto> getAllOrders();
    OrderDto viewOrder(Integer orderId);

}
