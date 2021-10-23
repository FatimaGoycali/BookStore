package com.example.about.bookstore.controller;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path = {"/","/search"})
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public String index(BookEntity bookEntity, Model model, String bookName){
        model.addAttribute("params",searchService.getBybookname(bookName));
                  return "navbar";


    }
}
