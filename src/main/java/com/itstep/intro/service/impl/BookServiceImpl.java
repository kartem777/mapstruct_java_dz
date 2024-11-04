package com.itstep.intro.service.impl;

import com.itstep.intro.dto.BookRequestDto;
import com.itstep.intro.dto.BookResponseDto;
import com.itstep.intro.mapper.BookMapper;
import com.itstep.intro.model.Book;
import com.itstep.intro.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itstep.intro.service.BookService;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = bookMapper.toModel(bookRequestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);

    }

    @Override
    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id);
        return bookMapper.toDto(book);
    }

    @Override
    public void updateBook(Integer bookId, BookRequestDto requestDto) {
        Book existingBook = bookRepository.findById(bookId);
        if (existingBook != null) {
            bookMapper.updateBookFromDto(requestDto, existingBook);
            bookRepository.save(existingBook);
        }
    }
}