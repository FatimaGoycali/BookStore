package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findAll();

//    Optional<BookEntity> findByBookType(String bookType);

    @Query(value = "SELECT * FROM  books.books"
            + " WHERE book_type= 'Detective'" +
            "  LIMIT 4 ",
            nativeQuery = true)
    List<BookEntity> findByTypeD();

    @Query(value = "SELECT * FROM  books.books"
            + " WHERE book_type= 'Detective'" +
            "  LIMIT 12 ",
            nativeQuery = true)
    List<BookEntity> findByDType();

    @Query(value = "SELECT * FROM  books.books"+
            "  LIMIT 20 ",
            nativeQuery = true)
    List<BookEntity> findAllBooks();



}
