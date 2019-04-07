package com.example.demo.web;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

	@RequestMapping("/times")
	public String times(@PageableDefault(value =5) Pageable pageable, Model model){
		Page<Time> times=timeService.findAll(pageable);
		model.addAttribute("times",times);

		model.addAttribute("showNext",!times.isLast());
		model.addAttribute("showPrev",!times.isFirst());
		model.addAttribute("numPage",times.getNumber());
		model.addAttribute("prevPage",times.getNumber()+1);
		model.addAttribute("nextPage",times.getNumber()-1);
		model.addAttribute("times",timeService.findAll(pageable));
		return "times";
	}

	@RequestMapping("/times/list")
	public String eventsList(@PageableDefault(value =5) Pageable pageable, Model model) {

		Page<Time> time = timeService.findAll(pageable);
		model.addAttribute("times", timeService.findAll(pageable));
		return "timeList";

	}

    @GetMapping("/times/{id}")
    public String showTimes(Model model, @PathVariable long id){
    	Optional<Time> time = timeService.findOne(id);
    	if(time.isPresent()) {
    		model.addAttribute("concreteTime", time.get());
    		List<SubTime> subInterv = time.get().getSubIntervals();
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
    public String saveTimer(Model model, @RequestParam String timeName, @RequestParam String startDate, @RequestParam String endDate,@PageableDefault(value =5) Pageable pageable){
    	Time time = new Time(timeName, startDate, endDate);
    	timeService.saveTimer(time);
		Page<Time> times=timeService.findAll(pageable);
		model.addAttribute("times",times);

		model.addAttribute("showNext",!times.isLast());
		model.addAttribute("showPrev",!times.isFirst());
		model.addAttribute("numPage",times.getNumber());
		model.addAttribute("prevPage",times.getNumber()+1);
		model.addAttribute("nextPage",times.getNumber()-1);
		model.addAttribute("events",timeService.findAll(pageable));
		return "times";
    }

    @PostMapping("/times/{id}/deleteTime")
    public String deleteTimer(Model model,@PathVariable long id,@PageableDefault(value =5) Pageable pageable){
    	timeService.deleteTimer(id);
		Page<Time> times=timeService.findAll(pageable);
		model.addAttribute("times",times);

		model.addAttribute("showNext",!times.isLast());
		model.addAttribute("showPrev",!times.isFirst());
		model.addAttribute("numPage",times.getNumber());
		model.addAttribute("prevPage",times.getNumber()+1);
		model.addAttribute("nextPage",times.getNumber()-1);
		model.addAttribute("events",timeService.findAll(pageable));
		return "times";
    }
    
    @GetMapping("/times/{id}/updateTime")
    public String updateTime(Model model, @PathVariable long id) {
    	Time time = timeService.findOne(id).get();
    	model.addAttribute("concreteTime", time);
		//List<SubTime> subInterv = time.getSubIntervals();
		//model.addAttribute("subIntervals", subInterv);
		List<Event> events = time.getEvents();
		model.addAttribute("eventListInt", events);
		return "concreteInterval";
    }
    
    
    @PostMapping("/times/{id}/updateTime")
    public String updateTime(Model model, @PathVariable long id, @RequestParam String startDate, @RequestParam String endDate,@PageableDefault(value =5) Pageable pageable) {
    	Time time = timeService.findOne(id).get();
    	time.setStartDate(startDate);
    	time.setEndDate(endDate);
    	timeService.saveTimer(time);
    	model.addAttribute("concreteTime", time);
		//List<SubTime> subInterv = time.getSubIntervals();
		//model.addAttribute("subIntervals", subInterv);
		List<Event> events = time.getEvents();

		Page<Time> times=timeService.findAll(pageable);
		model.addAttribute("times",times);
		model.addAttribute("showNext",!times.isLast());
		model.addAttribute("showPrev",!times.isFirst());
		model.addAttribute("numPage",times.getNumber());
		model.addAttribute("prevPage",times.getNumber()+1);
		model.addAttribute("nextPage",times.getNumber()-1);
		model.addAttribute("events",timeService.findAll(pageable));
		return "times";
    }
    
   @GetMapping("/times/{id}/newSubtime")
    public String saveSubtime(Model model, @PathVariable long id) {
    	Time time = timeService.findOne(id).get();
    	model.addAttribute("concreteTime", time);
		List<SubTime> subInterv = time.getSubIntervals();
		model.addAttribute("subIntervals", subInterv);
		List<Event> events = time.getEvents();
		model.addAttribute("eventListInt", events);
		return "concreteInterval";
    }
    

    @PostMapping("/times/{id}/newSubtime")
    public String saveSubtime(Model model,@PathVariable long id, @RequestParam String subTimeName, @RequestParam String startDate, @RequestParam String endDate) {
    	SubTime subTime = new SubTime(subTimeName, startDate, endDate);
    	Time time = timeService.findOne(id).get();
    	time.getSubIntervals().add(subTime);
    	timeService.saveTimer(time);
    	model.addAttribute("concreteTime", time);
		List<SubTime> subInterv = time.getSubIntervals();
		model.addAttribute("subIntervals", subInterv);
		List<Event> events = time.getEvents();
		model.addAttribute("eventListInt", events);
		return "concreteInterval";
    }
}

