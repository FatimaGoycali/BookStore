//package com.example.about.bookstore.controller;
//import com.example.about.bookstore.dao.entity.BookEntity;
//import com.example.about.bookstore.service.BookService;
//
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.MimeTypeUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.stream.IntStream;
//
//@Controller
//public class ShopBookController {
//
//
//    private BookService bookService;
//
//    public ShopBookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @RequestMapping (value = "/shop", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
//            headers = {"Accept=application/json"})
//    public String shopPage(@RequestParam(name = "direction", defaultValue = "DESC") String direction,
//                           @RequestParam(name = "property", defaultValue = "all") String property,
//                           @RequestParam(name = "sort", defaultValue = "sort") String sort,
//                           @RequestParam(name = "min", defaultValue = "$0") String min,
//                           @RequestParam(name = "max", defaultValue = "$100") String max,
//                           @RequestParam(value = "page",
//                                   required = false,
//                                   defaultValue = "0")
//                                   Integer page,
//                           Model model, HttpSession session) {
//
//
//
//           if(!min.equals("$0") || !max.equals("$100")){
//
//           Page<BookEntity> productPage =
//                   bookService.getProductPrice(page, direction, property,min,max,sort);
//
//           model.addAttribute("min",min);
//           model.addAttribute("max",max);
//           model.addAttribute("sort", sort);
//           model.addAttribute("property", property);
//           model.addAttribute("products", productPage);
//           model.addAttribute("numbers", IntStream.range(0, productPage.getTotalPages()).toArray());
//           }else if(!sort.equals("sort")){
//            Page<BookEntity> productPage = bookService.getProductSortDropDown(page, direction, property,min,max,sort);
//
//            model.addAttribute("min",min);
//            model.addAttribute("max",max);
//            model.addAttribute("sort", sort);
//            model.addAttribute("property", property);
//            model.addAttribute("products", productPage);
//            model.addAttribute("numbers", IntStream.range(0, productPage.getTotalPages()).toArray());
//           } else {
//
//            Page<BookEntity> productPage =
//                   bookService.getProduct(page, direction, property,sort);
//
//            model.addAttribute("min",min);
//            model.addAttribute("max",max);
//        model.addAttribute("sort", sort);
//        model.addAttribute("property", property);
//        model.addAttribute("products", productPage);
//        model.addAttribute("numbers", IntStream.range(0, productPage.getTotalPages()).toArray());
//       }
//        return "FreshMarketShop";
//    }
//
//
//
//
//}
