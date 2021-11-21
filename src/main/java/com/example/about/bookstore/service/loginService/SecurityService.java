package com.example.about.bookstore.service.loginService;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
