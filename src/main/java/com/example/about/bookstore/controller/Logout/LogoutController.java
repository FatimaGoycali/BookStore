package com.example.about.bookstore.controller.Logout;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {


    @RequestMapping("/logout")
    public String logout(Model model){
        return "signIn";
    }


}
