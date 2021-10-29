package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.dao.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }
    public List<BookEntity> searchBookByNameLike(String value) {

        return searchRepository.findByNameContainingIgnoreCase(value);
    }
    //hh
}
