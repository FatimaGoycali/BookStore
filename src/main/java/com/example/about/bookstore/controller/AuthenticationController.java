package com.example.about.bookstore.controller;


import com.example.about.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    private BookService bookService;

    public AuthenticationController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/signIn"}, method = RequestMethod.GET)
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }

    @RequestMapping(value = {"/signUp"}, method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
        return modelAndView;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("Dparameter", bookService.getByTypeD());
        model.addAttribute("Bparameter", bookService.getByTypeB());
        model.addAttribute("allbooks", bookService.getBookParams());
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
