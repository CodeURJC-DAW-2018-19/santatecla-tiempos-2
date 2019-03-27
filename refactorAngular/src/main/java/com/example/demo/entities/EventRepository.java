package com.example.demo.entities;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface EventRepository extends JpaRepository<Event, Long>{

    List<Event> findByNameEventOrLocation(String nameEvent, String location);
    List<Event>findByNameEvent(String nameEvent);
    List<Event>findByLocation(String loc);
    
}
