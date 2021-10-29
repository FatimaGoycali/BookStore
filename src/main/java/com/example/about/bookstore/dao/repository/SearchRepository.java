package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository  extends JpaRepository<BookEntity, Long> {

        List<BookEntity> findByNameContainingIgnoreCase(String name);

//hh
}
