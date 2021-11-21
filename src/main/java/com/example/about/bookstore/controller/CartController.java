package com.example.about.bookstore.controller;

import com.example.about.bookstore.dao.entity.ShoppingCart;
import com.example.about.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
        HttpSession session = request.getSession();

        Integer id = 1;
        List<Integer> listProducts = new ArrayList<>();
        listProducts.add(id);

        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", listProducts);
        } else {
           listProducts = (List<Integer>) session.getAttribute("cart");
           listProducts.add(id);
        }



        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
        if (sessionToken == null) {
            model.addAttribute("shoppingCart", new ShoppingCart());
        } else {
        ShoppingCart shoppingCart=shoppingCartService.getShoppingCartBySessionTokent(sessionToken);
          model.addAttribute("shoppingCart",shoppingCart);
        }
        return "shoppingCart";

    }
    @GetMapping("/removeCartItem/{id}")
    public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
        System.out.println("got here ");
        shoppingCartService.removeCartItemFromShoppingCart(id,sessionToken);
        return "redirect:/shoppingCart";
    }
    @GetMapping("/clearShoppingCart")
    public String clearShoopiString(HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
        request.getSession(false).removeAttribute("sessiontToken");
        shoppingCartService.clearShoppingCart(sessionToken);
        return "redirect:/shoppingCart";
    }


}