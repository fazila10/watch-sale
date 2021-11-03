package com.accenture.imaginea.service;

import com.accenture.imaginea.dao.*;
import com.accenture.imaginea.dto.*;
import com.accenture.imaginea.entity.*;
import com.accenture.imaginea.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserMapper userMapper;
    @Autowired
    RegistrationMapper registrationMapper;
    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductMapper productMapper;

    //Product
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(product -> productMapper.entityToDto(product))
                .collect(Collectors.toList());
    }

    private ProductDto findProduct(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        ProductDto productDto = null;
        if (product.isPresent()) {
           productDto = productMapper.entityToDto(product.get());
        }
        return productDto;
    }

    @Override
    public String addProduct(ProductDto productDTO) {
        Product product = productMapper.dtoToEntity(productDTO);
        ProductDto savedDto = productMapper.entityToDto(productRepository.save(product));
        return "Product added successfully with id:" + savedDto.getProductId();

    }

    @Override
    public ProductDto updateProduct(Integer productId,ProductDto productDto) {
        ProductDto updatedDto = null;
        if(findProduct(productId)!=null){
            productDto.setProductId(productId);
            Product product = productMapper.dtoToEntity(productDto);
            updatedDto = productMapper.entityToDto(productRepository.save(product));
        }
        return updatedDto;
    }

    @Override
    public String deleteProduct(Integer productId) {
        String output = "Product with id-"+productId+" cannot be found";
        ProductDto productDto = findProduct(productId);
        if(productDto!=null){
            Inventory inventory = inventoryRepository.findByProductId(productId);
            if(inventory!=null) {
                inventoryRepository.delete(inventory);
            }
            productRepository.delete(productMapper.dtoToEntity(productDto));
            output = "Product with id-"+productId+" successfully deleted";
        }
        return output;
    }

    //User
    @Override
    public String addUser(UserDto userDTO) {
         User user = userMapper.dtoToEntity(userDTO);
         UserDto addedDto = userMapper.entityToDto(userRepository.save(user));
         return "user added successfully with User Id:" + addedDto.getUserId();

    }

    private UserDto findUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        UserDto userDto = null;
        if (user.isPresent()) {
            userDto = userMapper.entityToDto(user.get());

        }
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(user -> userMapper.entityToDto(user))
                .collect(Collectors.toList());
    }

    //Registration
    @Override
    public String register(RegistrationInputDto registrationInputDto) {
        String reg = "User does not exist, Please Sign Up to continue";
        UserDto userDto = findUser(registrationInputDto.getUserId());
        if(userDto!=null){
            RegistrationDto registrationDto = RegistrationDto.builder().userDto(userDto).build();
            Registration register = registrationMapper.dtoToEntity(registrationDto);
            RegistrationDto registerDto = registrationMapper.entityToDto(registrationRepository.save(register));
            reg = "Registration successful, Your Registration Id is " + registerDto.getRegId();
        }

        return reg;
    }

    private RegistrationDto findRegistration(Integer registrationId) {
        Optional<Registration> registration = registrationRepository.findById(registrationId);
        RegistrationDto registrationDto = null;
        if (registration.isPresent()) {
            registrationDto = registrationMapper.entityToDto(registration.get());
        }
        return registrationDto;
    }

    @Override
    public List<RegistrationDto> getAllRegistrations() {
        List<Registration> registrationEntities = registrationRepository.findAll();
        return registrationEntities.stream()
                .map(registration -> registrationMapper.entityToDto(registration))
                .collect(Collectors.toList());
    }

    //Inventory
    @Override
    public String addItems(InventoryInputDto inventoryInputDto) {
        String item = "Product does not exist, Please check the Product Id";
        ProductDto productDto = findProduct(inventoryInputDto.getProductId());
        if(productDto!=null){
            InventoryDto inventoryDto = InventoryDto.builder()
                    .productDto(productDto)
                    .stockAvailable(inventoryInputDto.getStockAvailable())
                    .totalNumber(inventoryInputDto.getTotalNumber())
                    .build();
            Inventory inventory = inventoryMapper.dtoToEntity(inventoryDto);
            InventoryDto newInventoryDTO = inventoryMapper.entityToDto(inventoryRepository.save(inventory));
            item = "Item added successfully with Id is " + newInventoryDTO.getInventoryId();
            }
        return item;
    }

    private InventoryDto findItem(Integer inventoryId) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        InventoryDto inventoryDto = null;
        if (inventory.isPresent()) {
            inventoryDto = inventoryMapper.entityToDto(inventory.get());
        }
            return inventoryDto;
    }

    @Override
    public InventoryDto updateItems(Integer inventoryId, InventoryInputDto inventoryInputDto) {
        InventoryDto inventoryDto = findItem(inventoryId);
        if(inventoryDto != null){
            inventoryDto.setTotalNumber(inventoryInputDto.getTotalNumber());
            inventoryDto.setStockAvailable(inventoryInputDto.getStockAvailable());
            inventoryRepository.save(inventoryMapper.dtoToEntity(inventoryDto));
        }
        return inventoryDto;
    }

    @Override
    public boolean reduceStock(Integer productId) {
        boolean stock = false;
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if(inventory!=null){
            int count=inventory.getStockAvailable();
            if(count>0){
                inventory.setStockAvailable(count-1);
                inventoryRepository.save(inventory);
                stock = true;
            }
        }
        return stock;
    }

    @Override
    public List<InventoryDto> getAllItems() {
        List<Inventory> inventoryEntities = inventoryRepository.findAll();
        return inventoryEntities.stream()
                .map(inventory -> inventoryMapper.entityToDto(inventory))
                .collect(Collectors.toList());
    }

    //Order
    @Override
    public String placeOrder(OrderInputDto orderInputDto) {
        String output;
        RegistrationDto registrationDto = findRegistration(orderInputDto.getRegistrationId());
        ProductDto productDto = findProduct(orderInputDto.getProductId());
        if(registrationDto==null){
            output = "User does not registered, Please register to continue";
        }
        else if(productDto==null){
            output= "The product does not exist, Please enter the correct product Id";
        }
        else {
            OrderDto orderDto = OrderDto.builder()
                    .productDto(productDto)
                    .registrationDto(registrationDto)
                    .total(productDto.getPrice())
                    .build();

            Order newOrder = orderRepository.save(orderMapper.dtoToEntity(orderDto));
            OrderDto placedOrder = orderMapper.entityToDto(newOrder);
            output = "Order added successfully placed with Order Id:" + placedOrder.getOrderId() + " The Bill amount is:" + placedOrder.getTotal();
        }
        return output;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderEntities = orderRepository.findAll();
        return orderEntities.stream()
                .map(order -> orderMapper.entityToDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto viewOrder(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        OrderDto orderDto = null;
        if(order.isPresent()){
            orderDto = orderMapper.entityToDto(order.get());
        }
        return orderDto;
    }
}
