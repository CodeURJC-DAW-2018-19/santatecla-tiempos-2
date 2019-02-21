package com.example.demo.Entidades;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepositorio extends JpaRepository<Categorias, Long> {

    Page<Eventos> findByNameCategory(String nameCategory, Pageable page);
}
