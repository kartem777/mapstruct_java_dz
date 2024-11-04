package com.itstep.intro.repository;

import com.itstep.intro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserRepository {
    private final BookRepository bookRepository;

    @Autowired
    public UserRepository(BookRepository deviceRepository) {
        this.bookRepository = deviceRepository;
    }

    private final List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(new Random().nextInt());

        user.setBooks(user.getBooks().stream()
                .map(device -> {
                    Integer id = device.getId();
                    return bookRepository.findById(id);
                })
                .toList());

        users.add(user);
        return user;
    }

    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
