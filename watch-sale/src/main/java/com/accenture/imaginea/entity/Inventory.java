package com.accenture.imaginea.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int inventoryId;

    private int totalNumber;
    private int stockAvailable;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId", referencedColumnName = "productId",unique = true)
    private Product product;
}
