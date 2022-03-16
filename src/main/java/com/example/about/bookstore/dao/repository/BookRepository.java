package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findAll();

    @Query(value = "SELECT * FROM  books.books"
            + " WHERE book_type= 'Detective'" +
            "  LIMIT 4 ",
            nativeQuery = true)
    List<BookEntity> findByTypeD();

    @Query(value = "SELECT * FROM  books.books"
            + " WHERE book_type= 'Biographies'" +
            "  LIMIT 4 ",
            nativeQuery = true)
    List<BookEntity> findByTypeB();


}
