package com.accenture.imaginea.entity;


import lombok.*;
import javax.persistence.*;


@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="productId")
    private int productId;
    private String productName;
    private double price;

}
