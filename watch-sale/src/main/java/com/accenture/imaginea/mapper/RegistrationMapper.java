package com.accenture.imaginea.mapper;

import com.accenture.imaginea.dto.RegistrationDto;
import com.accenture.imaginea.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    @Mappings({
            @Mapping(target="regId", source="registration.regId"),
            @Mapping(target="regTime", source="registration.regTime"),
            @Mapping(target="userDto", source="registration.user")
    })
    RegistrationDto entityToDto(Registration registration);
    @Mappings({
            @Mapping(target="regId", source="registrationDto.regId"),
            @Mapping(target="regTime", source="registrationDto.regTime"),
            @Mapping(target="user", source="registrationDto.userDto")
    })
    Registration dtoToEntity(RegistrationDto registrationDto);
}
