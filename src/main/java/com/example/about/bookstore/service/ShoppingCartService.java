package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.dao.entity.CartItem;
import com.example.about.bookstore.dao.entity.ShoppingCart;
import com.example.about.bookstore.dao.repository.CartItemRepository;
import com.example.about.bookstore.dao.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private  BookService bookService;
    @Autowired CartItemRepository cartItemRepository;

    public ShoppingCart addShoppingCartFirstTime(Long id, String sessionToken, int quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setDate(new Date());
        cartItem.setBookEntity(bookService.getBookParams(id));
        shoppingCart.getItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        shoppingCart.setDate(new Date());
        return shoppingCartRepository.save(shoppingCart);

    }
    public ShoppingCart addToExistingShoppingCart(Long id, String sessionToken, int quantity) {

        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        BookEntity b = bookService.getBookParams(id);
        Boolean productDoesExistInTheCart = false;
        if (shoppingCart != null) {
            Set<CartItem> items = shoppingCart.getItems();
            for (CartItem item : items) {
                if (item.getBookEntity().equals(b)) {
                    productDoesExistInTheCart = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    shoppingCart.setItems(items);
                    return shoppingCartRepository.saveAndFlush(shoppingCart);
                }

            }
        }
        if(!productDoesExistInTheCart && (shoppingCart != null))
        {
            CartItem cartItem1 = new CartItem();
            cartItem1.setDate(new Date());
            cartItem1.setQuantity(quantity);
            cartItem1.setBookEntity(b);
            shoppingCart.getItems().add(cartItem1);
            return shoppingCartRepository.saveAndFlush(shoppingCart);
        }

        return this.addShoppingCartFirstTime(id, sessionToken, quantity);

    }

    public ShoppingCart getShoppingCartBySessionTokent(String sessionToken) {
        return  shoppingCartRepository.findBySessionToken(sessionToken);
    }
}
