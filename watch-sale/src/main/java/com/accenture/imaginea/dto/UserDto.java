package com.accenture.imaginea.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {
    private int userId;
    private String userName;
    private long phoneNumber;
    private String address;
}
