package com.example.demo.Entidades;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriasController {
	/*Unimos el controlador de la base de datos al repositorio*/
	@Autowired
	private CategoriasRepositorio catRep;
	
	@Autowired
	private EventoRepositorio eveRep;
	
	/*Inicializamos la base de datos*/
	@PostConstruct
	public void init() {
		Categorias category1 = new Categorias("Examen");
		catRep.save(category1);
		
		Eventos events1 = new Eventos("Daw",08/08/1200,"d","a");
		events1.getNameEvent().add(category1);
	}
	
}
