package com.example.demo.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface TimeRepository extends JpaRepository<Time, Long> {
	List<Time> findBySubIntervals(List<Time> subtimes);
}
