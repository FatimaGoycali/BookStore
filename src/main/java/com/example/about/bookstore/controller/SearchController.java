//package com.example.about.bookstore.controller;
//
//import com.example.about.bookstore.dao.entity.BookEntity;
//import com.example.about.bookstore.service.SearchService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/")
//public class SearchController {
//    private  SearchService searchService;
//
//    public SearchController(SearchService searchService) {
//        this.searchService = searchService;
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView search(@RequestParam("value") String value) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("fragments/searchFragment");
//        List<BookEntity> books = searchService.searchBookByNameLike(value);
//        mv.addObject("books", books);
//        return mv;
//    }
//
////hh
//
//}
