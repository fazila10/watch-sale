package com.accenture.imaginea.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="\"user\"")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="userId")
    private int userId;
    private String userName;
    private long phoneNumber;
    private String address;
}
