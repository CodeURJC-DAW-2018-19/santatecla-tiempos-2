package com.example.demo.api;

import com.example.demo.entities.Category;
import com.example.demo.entities.Event;
import com.example.demo.entities.Time;
import com.example.demo.entities.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/")
    public Collection<Time> getTimes(){
        return timeService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Time saveTime(@RequestBody Time time){
        timeService.saveTimer(time);
        return time;
    }

    @GetMapping("/{id}")
    public Optional<Time> getTimeId(@PathVariable long id){
        Time getTimeId=timeService.findOne(id).get();
        return timeService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public Time deleteTimer(@PathVariable long id){
        Time deleteTimer=timeService.findOne(id).get();
        timeService.deleteTimer(id);
        return deleteTimer;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Time updateTimer(@PathVariable long id, @RequestBody Time updateTimer){
        timeService.findOne(id).get();
        updateTimer.setId(id);
        timeService.saveTimer(updateTimer);
        return updateTimer;
    }
}
