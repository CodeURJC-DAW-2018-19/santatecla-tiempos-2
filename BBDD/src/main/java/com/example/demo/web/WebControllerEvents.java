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
    
    @Autowired
    private CategoryService catService;

    @GetMapping("/events")
    public String showEvents(Model model){	
        model.addAttribute("events",evenService.findAll());
        model.addAttribute("categoryList", catService.findAll());
        
        return "events";
    }
    
    @GetMapping("/newEvent")
    public String saveEvent(Model model){
    	model.addAttribute("events",evenService.findAll());
        return "events";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,@RequestParam String nameEvent, @RequestParam String eventDate, @RequestParam String eventLoc, @RequestParam String photoUrl, @RequestParam String wikiUrl, @RequestParam String selectedCat){
    	Event event = new Event(nameEvent,eventDate, eventLoc, wikiUrl);
    	event.setPhoto(photoUrl);
    	String[] catSplitted= selectedCat.split(",");
    	for(int i = 0; i< catSplitted.length; i++) {
    		List<Category> c = catService.findByName(catSplitted[i]);
    		event.getCategorias().add(c.get(0));
    	}
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
    
   /* @GetMapping("/searchEvent")
    public String searchEvent(Model model) {
    	model.addAttribute("events", evenService.findByName(search, search));
    	return "events";
    }*/
    
    @PostMapping("/searchEvent")
    public String searchEvent(Model model,@RequestParam String search) {
    	if(search.equals("")) {
    		model.addAttribute("events", evenService.findAll());
    		return "events";
    	}else {
    		model.addAttribute("events", evenService.findByName(search, search));
    		return "events";
    	}
    }
    
    


}
