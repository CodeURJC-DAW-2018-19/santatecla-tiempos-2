package com.example.demo.api;


import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Collection<Event> getEvents(){
        return evenService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvent(@RequestBody Event event, MultipartFile file){

      //foto.handleFileUpload(event,file);
        evenService.saveEvent(event);
        return event;

    }

    @GetMapping("/{id}")
    public Optional<Event> getEventId(@PathVariable long id){
        Event getEventId=evenService.findOne(id).get();
        return evenService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public Event deleteEvent(@PathVariable long id){
        Event deleteEvent=evenService.findOne(id).get();
        evenService.deleteEvent(id);
        return deleteEvent;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Event updateEvent(@PathVariable long id, @RequestBody Event updateEvent){
        evenService.findOne(id).get();

        updateEvent.setId(id);
        evenService.saveEvent(updateEvent);
        return updateEvent;
    }
}
