package com.itstep.intro.dto;

public record BookRequestDto(
        String name,
        String author,
        Integer year
) {
}
