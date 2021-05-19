package com.example.springbootonetomanybidirectionalrestmysql.jpa.mapper;


import com.example.springbootonetomanybidirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanybidirectionalrestmysql.jpa.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookDto toBookDTO(Book book);
    List<BookDto> toBookDTOs(List<Book> books);
    Book toBook(BookDto bookDto);
}
