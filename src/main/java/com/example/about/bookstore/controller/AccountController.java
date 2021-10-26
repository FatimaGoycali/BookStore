//package com.example.about.bookstore.controller;
//
//import com.example.about.bookstore.model.dto.UserDto;
//import com.example.about.bookstore.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//
//
//@Controller
//public class AccountController {
//
//    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
//
//    private final UserService userService;
//
//    @Autowired
//    public AccountController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }
//
//    @GetMapping("/signUp")
//    public String register(@ModelAttribute UserDto userDto, Model model) {
//        model.addAttribute("userDto", userDto);
//        return "signUp";
//    }
//
//
//    @PostMapping("/signUp")
//    public String saveUser(@Valid UserDto userDto, BindingResult bindingResult) {
//
//        if (userService.userExists((userDto.getEmail()))) {
//
//            bindingResult.addError(new FieldError("userDto", "email",
//                    "Email address already in user"));
//        }
//
//        if (userDto.getPassword() != null && userDto.getRpassword() != null) {
//            if (!userDto.getPassword().equals(userDto.getRpassword())) {
//                bindingResult.addError(new FieldError("userDto", "rpassword",
//                        "Password must be match"));
//            }
//        }
//        if (bindingResult.hasErrors()) {
//            return "signUp";
//        }
//        userService.saveUser(userDto);
//        return "redirect:/signIn";
//    }
//
//
//}
