package com.example.about.bookstore.mapper;
import com.example.about.bookstore.dao.entity.AboutEntity;
import com.example.about.bookstore.model.dto.AboutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMapper {
    AboutMapper INSTANCE  = Mappers.getMapper(AboutMapper.class);
    AboutDto mapToDto(AboutEntity aboutEntity);
}
