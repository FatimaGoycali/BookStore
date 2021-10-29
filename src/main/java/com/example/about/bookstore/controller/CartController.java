package com.example.about.bookstore.controller;

import com.example.about.bookstore.dao.entity.ShoppingCart;
import com.example.about.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
@Controller
public class CartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
                            @RequestParam("quantity") int quantity) {

        // sessiontToken
        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
        if (sessionToken == null) {

            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessiontToken", sessionToken);
            shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
        } else {
            shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
        }
        return "redirect:/";
    }

    @GetMapping("/shoppingCart")
    public String cart(HttpServletRequest request, Model model) {
        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
        if (sessionToken == null) {
            model.addAttribute("shoppingCart", new ShoppingCart());
        } else {
        ShoppingCart shoppingCart=shoppingCartService.getShoppingCartBySessionTokent(sessionToken);
          model.addAttribute("shoppingCart",shoppingCart);
        }
        return "shoppingCart";

    }
}