package com.accenture.imaginea.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

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
