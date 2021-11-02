package com.accenture.imaginea.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationDto {
    private int regId;
    private Date regTime;
    private UserDto userDto;
}
