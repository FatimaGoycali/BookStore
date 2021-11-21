package com.example.about.bookstore.controller;

//import com.example.about.bookstore.model.dto.UserDto;
import com.example.about.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"shop"})
    public String shop(Model model) {
        model.addAttribute("parameter", bookService.getBookParams());
        return "shop";

    }
    @GetMapping("/index")
    public String showHome(Model model) {
        model.addAttribute("Dparameter", bookService.getByTypeD());
        model.addAttribute("Bparameter", bookService.getByTypeB());
        model.addAttribute("allbooks", bookService.getBookParams());
        return "index";
    }


    @GetMapping("sbook/{bookId}/type/{bookType}")
    public String sbook(Model model, @PathVariable Integer bookId, String bookType) {
        model.addAttribute("book", bookService.findById(bookId));
        model.addAttribute("books", bookService.getBookParams());
        return "sbook";
    }

    @GetMapping({"contact"})
    public String contact() {
        return "contact";
    }


}




