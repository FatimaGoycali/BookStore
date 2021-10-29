package com.example.about.bookstore.dao.entity;

import javax.persistence.*;

@Entity
@Table(schema = "login",name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name = "role_name")
	private String name;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleId=" + roleId +
				", name='" + name + '\'' +
				'}';
	}
}
