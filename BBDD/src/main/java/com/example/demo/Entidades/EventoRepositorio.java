package com.example.demo.Entidades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepositorio  extends JpaRepository<Eventos, Long>{

    Page<Eventos> findByNameEvent(String nameEvent, Pageable page);
}
