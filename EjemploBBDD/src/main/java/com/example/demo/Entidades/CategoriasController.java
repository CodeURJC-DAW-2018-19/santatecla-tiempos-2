package com.example.demo.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriasController {
	/*Unimos el controlador de la base de datos al repositorio*/
	@Autowired
	private CategoriasRepositorio catRep;
	
	@Autowired
	private EventoRepositorio eveRep;

	@Autowired
	private TiempoRepositorio timeRep;

	public Optional<Categorias>findOne(long id){
		return catRep.findById(id);
	}

	public List<Categorias>findAll(){
		return catRep.findAll();
	}

	public void save(Categorias category){
		catRep.save(category);
	}

	public void delete(long id){
		catRep.deleteById(id);
	}
	//Paginacion de elemetos de la pestaña categoria

	@GetMapping("/practicaDAW/")
	public Page<Categorias> category (Pageable page){
		Page<Categorias>cat=catRep.findAll(PageRequest.of(0,10));
		return catRep.findAll(page);
	}

}
