package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.ContactUs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactUs, Long> {
}
