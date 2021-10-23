package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//
@Repository
public interface SearchRepository
        extends CrudRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

    List<BookEntity> findByNameContainingIgnoreCase(String bookName);
}
