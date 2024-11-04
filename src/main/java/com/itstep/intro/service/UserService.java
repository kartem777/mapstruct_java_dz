package com.itstep.intro.service;

import com.itstep.intro.dto.UserDetailedDto;
import com.itstep.intro.dto.UserDto;
import com.itstep.intro.dto.UserRegistrationDto;
import com.itstep.intro.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDetailedDto addUser(UserRegistrationDto userDto);
    UserDetailedDto getUserById(Integer id);
    void updateUser(Integer userId, UserRegistrationDto registrationDto);
}
