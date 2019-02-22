package com.example.demo.entities;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{

    Page<Event> findByNameEvent(String nameEvent, Pageable page);
}
