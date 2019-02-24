package com.example.demo.web;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebControllerTimes extends WebController{


    @Autowired
    private TimeService timeService;

    @GetMapping("/times")
    public String showTimes(Model model){
        model.addAttribute("times",timeService.findAll());
        return "times";
    }


    @GetMapping("/times/{id}")
    public String showTimes(Model model, @PathVariable long id){
    	Optional<Time> time = timeService.findOne(id);
    	if(time.isPresent()) {
    		model.addAttribute("concreteTime", time.get());
    		List<subTime> subInterv = time.get().getSubIntervals();
    		model.addAttribute("subIntervals", subInterv);
    		List<Event> events = time.get().getEvents();
    		model.addAttribute("eventListInt", events);
    	}
    	
        return "concreteInterval";
    }
    
    @GetMapping("/newTime")
    public String saveTime(Model model){
    	model.addAttribute("times",timeService.findAll());
        return "times";
    }

    @PostMapping("/newTime")
    public String saveTimer(Model model, @RequestParam String timeName, @RequestParam String startDate, @RequestParam String endDate){
    	Time time = new Time(timeName, startDate, endDate);
    	timeService.saveTimer(time);
    	model.addAttribute("times", timeService.findAll());    	
        return "times";
    }

    @GetMapping("/deleteTime/{id}")
    public String deleteTimer(Model model,@PathVariable long id){

        timeService.deleteTimer(id);
        return "practicaDAW";
    }
}
