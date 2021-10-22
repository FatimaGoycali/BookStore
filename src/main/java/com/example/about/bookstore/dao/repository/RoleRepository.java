package com.example.about.bookstore.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query( value = "select * from role where role_name=:role", nativeQuery = true)
    Role findRoleName(@Param("role") String role);
    Role findByName(String name);

}
