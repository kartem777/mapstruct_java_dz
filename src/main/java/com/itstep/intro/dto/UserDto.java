package com.itstep.intro.dto;

import java.util.List;

public record UserDto(
        Integer id,
        String name,
        String email
) {
}
