package com.example.demo.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface SubTimeRepository extends JpaRepository<SubTime, Long> {
	
}
