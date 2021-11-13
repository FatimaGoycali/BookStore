package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
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

//    @Query(value = "select * from books.books WHERE book_type='Detective'", nativeQuery = true)
//    Page<BookEntity> findDetective(Pageable pageable);
//
//    @Query(value = "select * from books.books WHERE book_type='Biographies'", nativeQuery = true)
//    Page<BookEntity> findBiographies(Pageable pageable);
//
////    @Query(value = "select * from books.books WHERE book_type='Business'", nativeQuery = true)
////    Page<BookEntity> findBusiness(Pageable pageable);
//
////    @Query(value = "select * from books.books WHERE book_type='Comics'", nativeQuery = true)
////    Page<BookEntity> findComics(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Science'", nativeQuery = true)
////    Page<BookEntity> findScience(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='History'", nativeQuery = true)
////    Page<BookEntity> findHistory(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Horror'", nativeQuery = true)
////    Page<BookEntity> findHorror(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Kids'", nativeQuery = true)
////    Page<BookEntity> findKids(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Fiction'", nativeQuery = true)
////    Page<BookEntity> findFiction(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Romance'", nativeQuery = true)
////    Page<BookEntity> findRomance(Pageable pageable);
////
////    @Query(value = "select * from books.books WHERE book_type='Fantasy'", nativeQuery = true)
////    Page<BookEntity> findFantasy3(Pageable pageable);
//
//    @Query(value = "select * from books.books ", nativeQuery = true)
//    Page<BookEntity> findAll(Pageable pageable);
//
//    @Query(value = "SELECT * FROM books.books WHERE book_type = :bookType and book_price Between :startPrice and :endPrice   " ,nativeQuery = true)
//    Page<BookEntity> findByPriceAndBookCategory(Pageable pageable,@Param("startPrice") String minPrice,
//                                                      @Param("endPrice")String maxPrice, @Param("bookType") String bookType);
//
//
//
//
//    @Query(value = "SELECT * FROM books.books WHERE book_price Between :startPrice and :endPrice   " ,nativeQuery = true)
//    Page<BookEntity> findAllByPriceAndBookCategory(Pageable pageable,@Param("startPrice") String minPrice,
//                                                         @Param("endPrice")String maxPrice);
//
//    @Query(value = "SELECT * FROM books.books WHERE book_price Between :startPrice and :endPrice", nativeQuery = true)
//    Page<BookEntity> findAllPrice(Pageable pageable,@Param("startPrice") String minPrice,
//                                     @Param("endPrice")String maxPrice);
//
//
//    @Query(value = "SELECT * FROM books.books WHERE book_type='Detective' and book_price BETWEEN :startPrice and :endPrice", nativeQuery = true)
//    Page<BookEntity> findDetectivePrice(Pageable pageable,@Param("startPrice") String minPrice,
//                                      @Param("endPrice")String maxPrice);
//
//    @Query(value = "SELECT * FROM books.books WHERE book_type='Biographies' and book_price BETWEEN :startPrice and :endPrice", nativeQuery = true)
//    Page<BookEntity> findBiographiesPrice(Pageable pageable,@Param("startPrice") String minPrice,
//                                        @Param("endPrice")String maxPrice);
//
//
//    @Query(value = "SELECT * FROM books.books WHERE book_name=:bookName", nativeQuery = true )
//    List<BookEntity> findbyName(@Param("bookName") String bookName);

}
