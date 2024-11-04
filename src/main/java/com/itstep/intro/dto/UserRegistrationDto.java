package com.itstep.intro.dto;

import java.util.List;

public record UserRegistrationDto(
        String name,
        String email,
        List<Integer> booksIds
) {
}
