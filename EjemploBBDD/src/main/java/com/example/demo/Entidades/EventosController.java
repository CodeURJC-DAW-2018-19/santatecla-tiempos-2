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
public class EventosController {
    @Autowired
    private EventoRepositorio eveRep;

    //Paginacion
    @GetMapping("/practicaDAW/")
    public Page<Eventos> category (Pageable page){
        Page<Eventos>event=eveRep.findAll(PageRequest.of(0,10));
        return eveRep.findAll(page);
    }

    public Optional<Eventos>findOne(long id){
        return eveRep.findById(id);
    }

    public List<Eventos> findAll(){
        return eveRep.findAll();
    }

    public void save(Eventos event){
        eveRep.save(event);
    }

    public void delete(long id){
        eveRep.deleteById(id);
    }
}
