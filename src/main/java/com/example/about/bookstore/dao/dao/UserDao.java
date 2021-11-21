package com.example.about.bookstore.dao.dao;


import com.example.about.bookstore.dao.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
