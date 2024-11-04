package com.itstep.intro.mapper;

import com.itstep.intro.config.MapperConfig;
import com.itstep.intro.dto.BookRequestDto;
import com.itstep.intro.dto.BookResponseDto;
import com.itstep.intro.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookResponseDto toDto(Book book);

    Book toModel(BookRequestDto requestDto);

    @Named("byId")
    default Book bookById(Integer bookId) {
        Book book = new Book();
        book.setId(bookId);
        return book;
    }
    @Mapping(target = "id", ignore = true) // Ignore the ID field during update
    void updateBookFromDto(BookRequestDto requestDto, @MappingTarget Book book);
}