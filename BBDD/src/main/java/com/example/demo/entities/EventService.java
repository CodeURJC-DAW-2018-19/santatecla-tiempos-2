package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eveRep;

    //Paginacion
    @GetMapping("/practicaDAW/")
    public Page<Event> eventosPage (Pageable page){
        Page<Event> event=eveRep.findAll(PageRequest.of(0,10));
        return eveRep.findAll(page);
    }

    public Optional<Event> findOne(long id){
        return eveRep.findById(id);
    }

    public List<Event> findAll(){
        return eveRep.findAll();
    }

    public void saveEvent(Event event){
        eveRep.save(event);
    }

    public void deleteEvent(long id){
        eveRep.deleteById(id);
    }

    //Eventos
/*
    @GetMapping("/")
    public String showEvents(Model model){
        model.addAttribute("eventos",eveRep.findAll());
        return "practicaDAW";
    }


    @GetMapping("/Eventos/{id}")
    public String showEvents(Model model, @PathVariable long id){
        Optional<Eventos> event=eveRep.findById(id);
        if(event.isPresent()){
            model.addAttribute("evento", event.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,Eventos event){
        eveRep.save(event);
        return "practicaDAW";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model,@PathVariable long id){

        eveRep.deleteById(id);
        return "practicaDAW";
    }*/
}
