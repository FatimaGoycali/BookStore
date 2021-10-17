package com.example.about.bookstore.dao.repository;

import com.example.about.bookstore.dao.entity.AboutEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutRepository extends CrudRepository<AboutEntity, Integer> {

    Optional<AboutEntity> findById(Integer id);
}
