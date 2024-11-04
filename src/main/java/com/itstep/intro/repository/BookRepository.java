package com.itstep.intro.repository;

import com.itstep.intro.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Book save(Book book) {
        book.setId(new Random().nextInt());
        books.add(book);
        return book;
    }

    public Book findById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

}
