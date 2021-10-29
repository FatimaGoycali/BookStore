package com.example.about.bookstore.controller.LoginController;

import com.example.about.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    private BookService bookService;

    public DemoController(BookService bookService) {
        this.bookService = bookService;
    }

	@GetMapping("/index")
	public String showHome(Model model) {
        model.addAttribute("Dparameter", bookService.getByTypeD());
        model.addAttribute("Bparameter", bookService.getByTypeB());
        model.addAttribute("allbooks", bookService.getBookParams());
        return "index";
	}

	// add request mapping for /leaders
	// add request mapping for /systems

	@GetMapping("/systems")
	public String showSystems() {

		return "systems";
	}

}










