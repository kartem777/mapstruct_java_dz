package com.itstep.intro.service.impl;

import com.itstep.intro.dto.UserDetailedDto;
import com.itstep.intro.dto.UserDto;
import com.itstep.intro.dto.UserRegistrationDto;
import com.itstep.intro.mapper.UserMapper;
import com.itstep.intro.model.User;
import com.itstep.intro.repository.UserRepository;
import com.itstep.intro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDetailedDto addUser(UserRegistrationDto userDto) {
        User user = userMapper.toModel(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDetailedDto(savedUser);
    }

    @Override
    public UserDetailedDto getUserById(Integer id) {
        User user = userRepository.findById(id);
        return userMapper.toDetailedDto(user);
    }

    @Override
    public void updateUser(Integer userId, UserRegistrationDto registrationDto) {
        User existingUser = userRepository.findById(userId);
        if (existingUser != null) {
            userMapper.updateUserFromDto(registrationDto, existingUser);
            userRepository.save(existingUser);
        }
    }
}
