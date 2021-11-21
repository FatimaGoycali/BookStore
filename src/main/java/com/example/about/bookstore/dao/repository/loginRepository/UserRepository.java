package com.example.about.bookstore.dao.repository.loginRepository;

import com.example.about.bookstore.dao.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
