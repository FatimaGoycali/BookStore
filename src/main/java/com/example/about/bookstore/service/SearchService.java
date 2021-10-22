//package com.example.about.bookstore.service;
//
//import com.example.about.bookstore.dao.entity.BookEntity;
//import com.example.about.bookstore.dao.repository.SearchRepository;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class SearchService {
//    private SearchRepository searchRepository;
//    public Iterable<BookEntity> getBybookname(String bookName){
//        return  searchRepository.findByNameContainingIgnoreCase(bookName);
//    }
//}
