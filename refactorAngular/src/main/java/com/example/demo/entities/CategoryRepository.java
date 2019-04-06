package com.example.demo.entities;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface CategoryRepository extends JpaRepository<Category, Long> {

   List<Category> findByNameCategory(String nameCategory);
}
