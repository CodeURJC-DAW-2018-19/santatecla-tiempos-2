package com.example.demo.api;

import com.example.demo.entities.Category;
import com.example.demo.entities.Event;
import com.example.demo.entities.Time;
import com.example.demo.entities.TimeService;
import com.example.demo.users.User;
import com.example.demo.users.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/times")
public class TimeRestController {

    interface VisitanteView extends Time.Visitante{}

    @Autowired
    private TimeService timeService;
    @Autowired
    private UserComponent userComponent;



    @GetMapping("/")
    public Page<Time> getTimes(@PageableDefault(value =5) Pageable pageable, @AuthenticationPrincipal User user){
        Page<Time>times=timeService.findAll(pageable);
        return timeService.findAll(pageable);
    }

    @GetMapping("/visitante")
    @JsonView(VisitanteView.class)
    public Page<Time> getTimesIntervals(@PageableDefault(value =5) Pageable pageable, @AuthenticationPrincipal User user){
        Page<Time>times=timeService.findAll(pageable);
        return timeService.findAll(pageable);
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
    public  Time updateTimer(@PathVariable long id, @RequestBody Time updateTimer){
        timeService.findOne(id).get();
        updateTimer.setId(id);
        timeService.saveTimer(updateTimer);
        return updateTimer;
    }
}
