package com.accenture.imaginea.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="\"order\"")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int orderId;

    private double total;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId", referencedColumnName = "productId",updatable=false,foreignKey = @ForeignKey(name = "productId"))
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "regId", referencedColumnName = "regId",foreignKey = @ForeignKey(name = "regId"))
    private Registration registration;

}
