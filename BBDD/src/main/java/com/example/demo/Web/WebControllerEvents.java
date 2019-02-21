package com.example.demo.Web;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WebControllerEvents {


    @Autowired
    private EventService evenService;
    //Eventos

    @GetMapping("/Eventos")
    public String showEvents(Model model){
        model.addAttribute("eventos",evenService.findAll());
        return "practicaDAW";
    }


    @GetMapping("/Eventos/{id}")
    public String showEvents(Model model, @PathVariable long id){
        Optional<Event> event=evenService.findOne(id);
        if(event.isPresent()){
            model.addAttribute("evento", event.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,Event event){
        evenService.saveEvent(event);
        return "practicaDAW";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model,@PathVariable long id){

        evenService.deleteEvent(id);
        return "practicaDAW";
    }
}
