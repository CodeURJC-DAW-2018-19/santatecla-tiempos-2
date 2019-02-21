package com.example.demo.entities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepositorio extends JpaRepository<Categorias, Long> {

    Page<Event> findByNameCategory(String nameCategory, Pageable page);
}
