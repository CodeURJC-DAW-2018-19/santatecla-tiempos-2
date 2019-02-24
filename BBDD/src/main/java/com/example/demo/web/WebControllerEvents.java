package com.example.demo.web;

import com.example.demo.entities.*;
import com.example.demo.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class WebControllerEvents extends WebController {


    @Autowired
    private EventService evenService;
    //Eventos

    @GetMapping("/events")
    public String showEvents(Model model){
    	//List<Event> eventList = evenService.findAll();    	
        model.addAttribute("events",evenService.findAll());
        return "events";
    }
    
    @GetMapping("/newEvent")
    public String saveEvent(Model model){
    	model.addAttribute("events",evenService.findAll());
        return "events";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,@RequestParam String nameEvent, @RequestParam String eventDate, @RequestParam String eventLoc, @RequestParam String photoUrl, @RequestParam String wikiUrl){
    	Event event = new Event(nameEvent,eventDate, eventLoc, wikiUrl);
    	event.setPhoto(photoUrl);
        evenService.saveEvent(event);
        model.addAttribute("events", evenService.findAll());
        return "events";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model){
    	model.addAttribute("events",evenService.findAll());
        return "events";
    }
    
    @PostMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model,@PathVariable long id) {
    	evenService.deleteEvent(id);
    	model.addAttribute("events", evenService.findAll());
    	return "events";
    }
    


}
