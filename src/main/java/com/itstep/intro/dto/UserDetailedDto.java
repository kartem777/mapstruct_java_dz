package com.itstep.intro.dto;

import java.util.List;

public record UserDetailedDto(
        Integer id,
        String name,
        String email,
        List<BookResponseDto> books
) {
}
