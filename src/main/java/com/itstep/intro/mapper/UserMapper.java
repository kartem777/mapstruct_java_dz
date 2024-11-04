package com.itstep.intro.mapper;

import com.itstep.intro.config.MapperConfig;
import com.itstep.intro.dto.UserDetailedDto;
import com.itstep.intro.dto.UserDto;
import com.itstep.intro.dto.UserRegistrationDto;
import com.itstep.intro.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = BookMapper.class)
public interface UserMapper {
    UserDto toDto(User user);

    UserDetailedDto toDetailedDto(User user);
    @Mapping(target = "books", source = "booksIds", qualifiedByName = "byId")
    User toModel(UserRegistrationDto registrationDto);

    @Mapping(target = "id", ignore = true) // Ignore the ID field during update
    void updateUserFromDto(UserRegistrationDto registrationDto, @MappingTarget User user);
}
