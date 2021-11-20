package com.example.about.bookstore.service.loginService;

import com.example.about.bookstore.dao.entity.login.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
