package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.dao.repository.BookRepository;
import com.example.about.bookstore.mapper.AboutMapper;
import com.example.about.bookstore.mapper.BookMapper;
import com.example.about.bookstore.model.dto.AboutDto;
import com.example.about.bookstore.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    //null olanda ,price,navbar,crud or jpa rep,

    public List<BookDto> getBookParams() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public BookEntity findById(Integer id){
        return bookRepository.findById(id).get();
    }
    public BookEntity findByType(String bookType){
        return bookRepository.findByBookType(bookType).get();
    }
}



