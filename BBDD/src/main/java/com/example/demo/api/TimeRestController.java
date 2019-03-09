package com.example.demo.api;

import com.example.demo.entities.Category;
import com.example.demo.entities.Time;
import com.example.demo.entities.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/time")
    public Collection<Time> getTimes(){
        return timeService.findAll();
    }

    @PostMapping("/newTimes")
    @ResponseStatus(HttpStatus.CREATED)
    public Time saveTime(@RequestBody Time time){
        timeService.saveTimer(time);
        return time;
    }

    @DeleteMapping("/deleteTimes/{id}")
    public Time deleteTimer(@PathVariable long id){
        Time deleteTimer=timeService.findOne(id).get();
        timeService.deleteTimer(id);
        return deleteTimer;
    }

    @PutMapping("/updateTimes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Time updateTimer(@PathVariable long id, @RequestBody Time updateTimer){
        timeService.findOne(id).get();
        updateTimer.setId(id);
        timeService.saveTimer(updateTimer);
        return updateTimer;
    }
}
