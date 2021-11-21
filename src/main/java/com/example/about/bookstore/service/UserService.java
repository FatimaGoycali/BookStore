package com.example.about.bookstore.service;


import com.example.about.bookstore.dao.entity.User;
import com.example.about.bookstore.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
