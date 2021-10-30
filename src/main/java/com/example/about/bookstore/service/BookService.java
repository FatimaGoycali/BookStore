package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.dao.repository.BookRepository;
import com.example.about.bookstore.mapper.BookMapper;
import com.example.about.bookstore.model.dto.BookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBookParams() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public BookEntity findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public List<BookEntity> getByTypeD() {
        List<BookEntity> books =
                bookRepository.findByTypeD();
        return books;
    }

    public List<BookEntity> getByTypeB() {
        List<BookEntity> books =
                bookRepository.findByTypeB();
        return books;
    }

//
//    public Page<BookEntity> getProduct(Integer page, String direction, String property, String sort) {
//
//        if (property.equals("Detective")) {
//            return bookRepository.findDetective(PageRequest.of(page, 8));
//        } else if (property.equals("Biographies")) {
//            return bookRepository.findBiographies(PageRequest.of(page, 8));
//        }
////        else if (property.equals("Business")) {
////            return bookRepository.findBusiness((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Comics")) {
////            return bookRepository.findComics((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Science")) {
////            return bookRepository.findScience((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("History")) {
////            return bookRepository.findHistory((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Horror")) {
////            return bookRepository.findHorror((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Kids")) {
////            return bookRepository.findKids((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Fiction")) {
////            return bookRepository.findFiction((Pageable) PageRequest.of(page, 8));
////        } else if (property.equals("Kids")) {
////            return bookRepository.findKids((Pageable) PageRequest.of(page, 8));
////        }
//
//        return bookRepository.findAll(PageRequest.of(page, 8));
//
//    }
//
//
//    public Page<BookEntity> getProductPrice(Integer page, String direction, String property, String min, String max, String sort) {
//
//
//        String findBy = "book_name";
//        Sort.Direction order = Sort.Direction.ASC;
//
//        if (sort.equals("Price (low to high)")) {
//            findBy = "book_price";
//            order = Sort.Direction.ASC;
//        } else if (sort.equals("Price (high to low)")) {
//            findBy = "book_price";
//            order = Sort.Direction.DESC;
//        } else if (sort.equals("Name Z-A")) {
//            findBy = "book_price";
//            order = Sort.Direction.DESC;
//        } else if (sort.equals("Name A-Z")) {
//            findBy = "book_name";
//            order = Sort.Direction.ASC;
//        }
//
//
//        String first = min.substring(1);
//        String second = max.substring(1);
//
//        if (property.equals("Detective")) {
//            return bookRepository.findDetectivePrice(PageRequest.of(page, 8, Sort.by(order, findBy)), first, second);
//        } else if (property.equals("Biographies")) {
//            return bookRepository.findBiographiesPrice(PageRequest.of(page, 8, Sort.by(order, findBy)), first, second);
//        }
//
//
//        return bookRepository.findAllPrice(PageRequest.of(page, 8, Sort.by(order, findBy)), first, second);
//
//    }
//
//    public List<BookEntity> findAll() {
//        return bookRepository.findAll();
//    }
//
//    public Page<BookEntity> getProducts(Integer page, String productType, String min, String max, String sort) {
//
//        String findBy = "book_name";
//        Sort.Direction order = Sort.Direction.ASC;
//
//        if (sort.equals("Price (low to high)")) {
//            findBy = "book_price";
//            order = Sort.Direction.ASC;
//        } else if (sort.equals("Price (high to low)")) {
//            findBy = "book_price";
//            order = Sort.Direction.DESC;
//        } else if (sort.equals("Name Z-A")) {
//            findBy = "book_price";
//            order = Sort.Direction.DESC;
//        } else if (sort.equals("Name A-Z")) {
//            findBy = "book_name";
//            order = Sort.Direction.ASC;
//        }
//
//
//        String first = min.substring(1);
//        String second = max.substring(1);
//
//
//        if (productType.equals("all")) {
//            return bookRepository.findAllByPriceAndBookCategory(PageRequest.of(page, 8, Sort.by(order, findBy)), first, second);
//        }
//
//    }
//
//
//    public Page<BookEntity> getProductSort(Integer page, String productType, String min,String max,String sort){
//
//       String findBy = null;
//       Sort.Direction order = null;
//
//       if (sort.equals("Price (low to high)")){
//           findBy="book_price";
//           order=Sort.Direction.ASC;
//       }else if (sort.equals("Price (high to low)")){
//           findBy="book_price";
//           order=Sort.Direction.DESC;
//       }else if (sort.equals("Name Z-A")){
//           findBy="book_price";
//           order=Sort.Direction.DESC;
//       }else if (sort.equals("Name A-Z")){
//           findBy="book_name";
//           order=Sort.Direction.ASC;
//       }
//
//
//        String first=min.substring(1);
//        String second=max.substring(1);
//
//
//
//        if(productType.equals("all")){
//            return  bookRepository.findAllByPriceAndBookCategory(PageRequest.of(page, 8,Sort.by(order,findBy)),first,second);
//        }
//
//        return  bookRepository.findByPriceAndBookCategory(PageRequest.of(page, 8,Sort.by(order,findBy)),first,second, productType);
//    }
//
//
//
//    public Page<BookEntity> getDetective(Pageable pageable){
//
//        return bookRepository.findDetective(pageable);
//    }
//
//
//    public Page<BookEntity> getProductSortDropDown(Integer page, String direction, String productType, String min, String max, String sort){
//
//
//        String findBy = null;
//        Sort.Direction order = null;
//
//        if (sort.equals("Price (low to high)")){
//            findBy="book_price";
//            order=Sort.Direction.ASC;
//        }else if (sort.equals("Price (high to low)")){
//            findBy="book_price";
//            order=Sort.Direction.DESC;
//        }else if (sort.equals("Name Z-A")){
//            findBy="book_price";
//            order=Sort.Direction.DESC;
//        }else if (sort.equals("Name A-Z")){
//            findBy="book_name";
//            order=Sort.Direction.ASC;
//        }
//
//
//        String first=min.substring(1);
//        String second=max.substring(1);
//
//
//
//
//        if(productType.equals("Detective")){
//            return bookRepository.findDetectivePrice(PageRequest.of(page, 8,Sort.by(order,findBy)),first,second);
//        } else  if(productType.equals("Biographies")){
//            return bookRepository.findBiographiesPrice(PageRequest.of(page, 8,Sort.by(order,findBy)),first,second);
//        }
//
//
//        bookRepository.findAllPrice(PageRequest.of(page, 8,Sort.by(order,findBy)),first,second);
//
//
//
//
//    }


}