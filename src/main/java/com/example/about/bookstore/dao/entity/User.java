package com.example.about.bookstore.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "login", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "rpassword")
    private String rpassword;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(schema = "login",name = "user_roles",joinColumns = @JoinColumn(name = "auth_user_id")
            ,inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long userId, String userName, String email, String password, String rpassword) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rpassword = rpassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }
}
