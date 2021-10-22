package com.example.about.bookstore.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "login", name = "role")
public class Role {
    @Id
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "user_roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        super();
        this.roleName = name;
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }
}


