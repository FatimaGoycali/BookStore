package com.example.about.bookstore.dao.repository.loginRepository;

import com.example.about.bookstore.dao.entity.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
