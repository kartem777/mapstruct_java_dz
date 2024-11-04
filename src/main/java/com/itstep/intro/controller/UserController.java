package com.itstep.intro.controller;

import com.itstep.intro.dto.UserDetailedDto;
import com.itstep.intro.dto.UserDto;
import com.itstep.intro.dto.UserRegistrationDto;
import com.itstep.intro.model.User;
import com.itstep.intro.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService UserService) {
        this.userService = UserService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDetailedDto addUser(@RequestBody UserRegistrationDto UserDto) {
        return userService.addUser(UserDto);
    }

    @GetMapping("/{id}")
    public UserDetailedDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}