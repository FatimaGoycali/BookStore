package com.example.about.bookstore.dao.repository;


import com.example.about.bookstore.dao.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
