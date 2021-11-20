package com.example.about.bookstore.controller;

import com.example.about.bookstore.service.AboutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
        private AboutService aboutService;

        public AboutController(AboutService aboutService) {
            this.aboutService = aboutService;
        }

        @GetMapping("/about")
        public String title(Model model) {
            model.addAttribute("parameter", aboutService.getAboutParam());
            return "about";

        }
    }


