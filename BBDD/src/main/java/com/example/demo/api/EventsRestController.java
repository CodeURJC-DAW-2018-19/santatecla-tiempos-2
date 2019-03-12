package com.example.demo.api;


import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventsRestController {

   @Autowired
    PhotoService foto;

    @Autowired
    private EventService evenService;

    @Autowired
    private CategoryService catService;

    @GetMapping("/")
    public Page<Event> getEvents(@PageableDefault(value =5) Pageable pageable){
        Page<Event>events=evenService.findAll(pageable);
        return evenService.findAll(pageable);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvent(@RequestBody Event event, MultipartFile file){

      //foto.handleFileUpload(event,file);
        evenService.saveEvent(event);
        return event;

    }

    @GetMapping("/{search}")
    public List<Event> getEventId(@PathVariable String search){

        evenService.findByName(search, search);

        return evenService.findByName(search,search);
    }
/*
    @GetMapping("/{loc}")
    public List<Event>getEventLoc(@PathVariable String loc){
        return evenService.findByLocation(loc);
    }*/


    @DeleteMapping("/{id}")
    public Event deleteEvent(@PathVariable long id){
        Event deleteEvent=evenService.findOne(id).get();
        evenService.deleteEvent(id);
        return deleteEvent;
    }

    @PutMapping("/{id}")
    public  Event updateEvent(@PathVariable long id, @RequestBody Event updateEvent){
        evenService.findOne(id).get();

        updateEvent.setId(id);
        evenService.saveEvent(updateEvent);
        return updateEvent;
    }
}
