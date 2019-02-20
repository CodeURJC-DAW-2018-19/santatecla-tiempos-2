package com.example.demo.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TiempoService {
	@Autowired
	public TiempoRepositorio timeRep;
	
	public Optional<Tiempo> findOne(long id) {
		return timeRep.findById(id);
	}
	
	@GetMapping("/practicaDAW/")
	public Page<Tiempo> time (Pageable page){
		Page<Tiempo> tim=timeRep.findAll(PageRequest.of(0,10));
		return timeRep.findAll(page);
	}
	
	public List<Tiempo> findAll(){
		return timeRep.findAll();
	}
	
	
}
