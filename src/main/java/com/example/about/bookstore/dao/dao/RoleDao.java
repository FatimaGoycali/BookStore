package com.example.about.bookstore.dao.dao;

import com.example.about.bookstore.dao.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
