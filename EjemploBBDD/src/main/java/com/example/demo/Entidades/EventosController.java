package com.example.demo.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EventosController {
    @Autowired
    private EventoRepositorio eveRep;

    //Paginacion
    public Page<Eventos> events(Pageable page){
        return eveRep.findAll(page);
    }

}
