package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service

public class TimeService {
	@Autowired
	public TimeRepository timeRep;
	

	
	/*@GetMapping("/practicaDAW")
	public Page<Time> time (Pageable page){
		Page<Time> tim=timeRep.findAll(PageRequest.of(0,10));
		return timeRep.findAll(page);
	}*/
	

	public Optional<Time> findOne(long id){
		return timeRep.findById(id);
	}

	public List<Time> findAll(){
		return timeRep.findAll();
	}

	public void saveTimer(Time tiempo){
		timeRep.save(tiempo);
	}

	public void deleteTimer(long id){
		timeRep.deleteById(id);
	}
	
	
	
}
