package com.itstep.intro.service;

import com.itstep.intro.dto.BookRequestDto;
import com.itstep.intro.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto addBook(BookRequestDto bookRequestDto);
    BookResponseDto getBookById(Integer id);
    void updateBook(Integer bookId, BookRequestDto requestDto);
}
