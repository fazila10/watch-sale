package com.accenture.imaginea.mapper;

import com.accenture.imaginea.dto.UserDto;
import com.accenture.imaginea.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToEntity(UserDto userDto);
    UserDto entityToDto(User user);
}
