package com.example.demo.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface SubTimeRepository extends JpaRepository<SubTime, Long> {
	
}
