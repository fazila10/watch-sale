package com.accenture.imaginea.controller;

import com.accenture.imaginea.dto.*;
import com.accenture.imaginea.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.accenture.imaginea.requests.RequestPath.*;

@RestController
public class SalesController {

    @Autowired
    private SalesService salesService;

    //Product
    @GetMapping(PRODUCTS)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(salesService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(PRODUCTS)
    public ResponseEntity<String> addProduct (@RequestBody ProductDto productDto){
        return new ResponseEntity<>(salesService.addProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping(PRODUCTS+"/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value="id") Integer productId,
                                                    @RequestBody ProductDto productDto){
        return new ResponseEntity<>(salesService.updateProduct(productId,productDto),HttpStatus.OK);
    }

    @DeleteMapping(PRODUCTS+"/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value ="id")Integer productId){
        return new ResponseEntity<>(salesService.deleteProduct(productId),HttpStatus.OK);
    }

    //User
    @GetMapping(USERS)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(salesService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping(USERS)
    public ResponseEntity<String> addUser (@RequestBody UserDto userDto){
        return new ResponseEntity<>(salesService.addUser(userDto), HttpStatus.CREATED);
    }

    //Registration
    @PostMapping(REGISTRATIONS)
    public ResponseEntity<String> register (@RequestBody RegistrationInputDto registrationInputDto){
        return new ResponseEntity<>(salesService.register(registrationInputDto), HttpStatus.CREATED);
    }
    @GetMapping(REGISTRATIONS)
    public ResponseEntity<List<RegistrationDto>> getAllRegistration() {
        return new ResponseEntity<>(salesService.getAllRegistrations(),HttpStatus.OK);
    }

    //Inventory
    @PostMapping(ITEMS)
    public ResponseEntity<String> addItem (@RequestBody InventoryInputDto inventoryInputDto){
        return new ResponseEntity<>(salesService.addItems(inventoryInputDto), HttpStatus.CREATED);
    }

    @PatchMapping(ITEMS+"/{id}")
    public ResponseEntity<InventoryDto> updateInventoryItem(@PathVariable(value="id") Integer inventoryId,
                                                            @RequestBody InventoryInputDto inventoryInputDto){
        return new ResponseEntity<>(salesService.updateItems(inventoryId, inventoryInputDto),HttpStatus.OK);
    }
    @GetMapping(ITEMS)
    public ResponseEntity<List<InventoryDto>> getAllItems() {
        return new ResponseEntity<>(salesService.getAllItems(),HttpStatus.OK);
    }

    //Order
    @PostMapping(ORDERS)
    public ResponseEntity<String> placeOrder (@RequestBody OrderInputDto orderInputDto){
        return new ResponseEntity<>(salesService.placeOrder(orderInputDto), HttpStatus.CREATED);
    }
    @GetMapping(ORDERS)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(salesService.getAllOrders(),HttpStatus.OK);
    }
    @GetMapping(ORDERS+"/{id}")
    public ResponseEntity<OrderDto> viewOrder(@PathVariable(value = "id")Integer orderId){
        return new ResponseEntity<>(salesService.viewOrder(orderId),HttpStatus.FOUND);
    }
}
