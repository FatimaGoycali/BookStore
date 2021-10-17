package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.ContactUs;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactUs, Long> {
}
