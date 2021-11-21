package com.example.about.bookstore.controller;
import com.example.about.bookstore.dao.entity.Item;
import com.example.about.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
//    @Autowired
//    private ShoppingCartService shoppingCartService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap,HttpSession session){
//        modelMap.put("total",total(session));
        return "/cart";
    }



    @Autowired
    private BookService bookService;
    @RequestMapping(value = "buy/{id}",method = RequestMethod.GET)
    public String buy(@PathVariable("id") int id, ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {

            List<Item> cart=new ArrayList<Item>();
            cart.add(new Item(bookService.findById(id),1 ));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart=(List<Item>) session.getAttribute("cart") ;
            int index=isExits(id,cart);
            if(index==-1){
                cart.add(new Item(bookService.findById(id),1 ));
            }else{
                int quantity=cart.get(index).getQuantity()+1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);


        }
        return "redirect:/cart";
    }

    @RequestMapping(value = "remove/{id}",method = RequestMethod.GET)
    public String  remove(@PathVariable("id") int id,  HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Item> cart=(List<Item>) session.getAttribute("cart") ;
        int index=isExits(id,cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String  update(  HttpServletRequest request){
        HttpSession session = request.getSession();
        String[] quantities=request.getParameterValues("quantity");
        List<Item> cart=(List<Item>) session.getAttribute("cart") ;
        for (int i = 0; i <cart.size() ; i++) {
            cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }



    private int isExits(int id,List<Item> cart){
        for(int i=0;i< cart.size();i++){
            if(cart.get(i).getBookEntity().getId()==id){
                return i;
            }
        }
        return -1;
    } }


























//package com.example.about.bookstore.controller;
//
//import com.example.about.bookstore.service.ShoppingCartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//@Controller
//public class CartController {
//    @Autowired
//    private ShoppingCartService shoppingCartService;
//
//    @PostMapping("/addToCart")
//    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
//                            @RequestParam("quantity") int quantity) {
//
//        // sessiontToken
//        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
//        if (sessionToken == null) {
//
//            sessionToken = UUID.randomUUID().toString();
//            request.getSession().setAttribute("sessiontToken", sessionToken);
//            shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
//        } else {
//            shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping("/shoppingCart")
//    public String cart(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession();
//
//        Integer id = 1;
//        List<Integer> listProducts = new ArrayList<>();
//        listProducts.add(id);
//
//        if (session.getAttribute("cart") == null) {
//            session.setAttribute("cart", listProducts);
//        } else {
//           listProducts = (List<Integer>) session.getAttribute("cart");
//           listProducts.add(id);
//        }
//
//
//
//        String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
//        if (sessionToken == null) {
//            model.addAttribute("shoppingCart", new ShoppingCart());
//        } else {
//        ShoppingCart shoppingCart=shoppingCartService.getShoppingCartBySessionTokent(sessionToken);
//          model.addAttribute("shoppingCart",shoppingCart);
//        }
//        return "shoppingCart";
//
//    }
//    @GetMapping("/removeCartItem/{id}")
//    public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
//        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
//        System.out.println("got here ");
//        shoppingCartService.removeCartItemFromShoppingCart(id,sessionToken);
//        return "redirect:/shoppingCart";
//    }
//    @GetMapping("/clearShoppingCart")
//    public String clearShoopiString(HttpServletRequest request) {
//        String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
//        request.getSession(false).removeAttribute("sessiontToken");
//        shoppingCartService.clearShoppingCart(sessionToken);
//        return "redirect:/shoppingCart";
//    }
//
//
//}