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

    @Autowired
    private CategoryRepository categoryRepository;


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
    
    public List<Event> findByName(String name, String loc){
    	return eveRep.findByNameEventOrLocation(name, loc);
    }

    public Page<Event> findAll (Pageable page){
        Page<Event> events=eveRep.findAll(PageRequest.of(0,10));
        return eveRep.findAll(page);
    }

    public List<Event>findByNameEvent(String nameEvent){
        return eveRep.findByNameEvent(nameEvent);
    }

    public List<Event>findByLocation(String location){
        return eveRep.findByLocation(location);
    }
}
