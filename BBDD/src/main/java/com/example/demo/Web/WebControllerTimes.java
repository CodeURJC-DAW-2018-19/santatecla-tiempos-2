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
public class WebControllerTimes {


    @Autowired
    private TimeService timeService;

    @GetMapping("/Tiempo")
    public String showTimes(Model model){
        model.addAttribute("eventos",timeService.findAll());
        return "practicaDAW";
    }


    @GetMapping("/tiempos/{id}")
    public String showTimes(Model model, @PathVariable long id){
        Optional<Time> timer=timeService.findOne(id);
        if(timer.isPresent()){
            model.addAttribute("tiempo", timer.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newTime")
    public String saveTimer(Model model,Time timer){
        timeService.saveTimer(timer);
        return "practicaDAW";
    }

    @GetMapping("/deleteTime/{id}")
    public String deleteTimer(Model model,@PathVariable long id){

        timeService.deleteTimer(id);
        return "practicaDAW";
    }
}
