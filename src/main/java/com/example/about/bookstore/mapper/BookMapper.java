package com.example.about.bookstore.mapper;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDto mapToDto(BookEntity bookEntity);
}
