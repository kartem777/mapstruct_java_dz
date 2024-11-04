package com.itstep.intro.dto;

public record BookResponseDto(
        Integer id,
        String name,
        String author,
        Integer year
) {
}
