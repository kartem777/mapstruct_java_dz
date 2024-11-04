package com.itstep.intro.controller;

import com.itstep.intro.dto.BookRequestDto;
import com.itstep.intro.dto.BookResponseDto;
import com.itstep.intro.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> getAllDevices() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookResponseDto addBook(@RequestBody BookRequestDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    public BookResponseDto getDeviceById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }
}