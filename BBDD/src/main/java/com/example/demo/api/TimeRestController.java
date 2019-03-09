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
    public Time deleteTime(@PathVariable long id){
        Time deleteTime=timeService.findOne(id).get();
        timeService.deleteTimer(id);
        return deleteTime;
    }

    @PutMapping("/updateTimes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Time updateTime(@PathVariable long id, @RequestBody Time updateTime){
        timeService.findOne(id).get();
        updateTime.setId(id);
        timeService.saveTimer(updateTime);
        return updateTime;
    }
}
