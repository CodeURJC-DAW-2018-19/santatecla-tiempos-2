package com.example.demo.api;


import com.example.demo.entities.*;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/events")
public class EventsRestController {

   @Autowired
    PhotoService foto;

    @Autowired
    private EventService evenService;

    @Autowired
    private CategoryService catService;

    @GetMapping("/")
    public Page<Event> getEvents(@PageableDefault(value =5) Pageable pageable){
        Page<Event>events=evenService.findAll(pageable);
        return evenService.findAll(pageable);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvent(@RequestBody Event event){

        evenService.saveEvent(event);
        return event;

    }

    @GetMapping("/{search}")
    public List<Event> getEventId(@PathVariable String search){

        evenService.findByName(search, search);

        return evenService.findByName(search,search);
    }


    @DeleteMapping("/{id}")
    public Event deleteEvent(@PathVariable long id){
        Event deleteEvent=evenService.findOne(id).get();
        evenService.deleteEvent(id);
        return deleteEvent;
    }

    @PutMapping("/{id}")
    public  Event updateEvent(@PathVariable long id, @RequestBody Event updateEvent){
        evenService.findOne(id).get();

        updateEvent.setId(id);
        evenService.saveEvent(updateEvent);
        return updateEvent;
    }
    
    @GetMapping("/{id}/image")
    public void downloadImage(@PathVariable long id, HttpServletResponse res) {
    	Event event = evenService.findOne(id).get();
    	if(event.isHasImage()) {
    		byte[] image = event.getPhoto();
    		res.setContentType("image/jpeg");
    		try {
    			FileCopyUtils.copy(image, res.getOutputStream());
    		}catch(Exception e) {e.printStackTrace();}
    	}
    }
    
    
    @PostMapping("/{id}/image")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage(@PathVariable long id, @RequestBody MultipartFile file, HttpServletResponse res) {
    	Event event = evenService.findOne(id).get();
    	
    	if(!file.isEmpty()) {
    		try {
    			event.setPhoto(file.getBytes());
    			event.setEncodedImage(Base64.encode(file.getBytes()));
    			event.setHasImage(true);
    		}catch(IOException ioe) {ioe.printStackTrace();}
    	}
    	
    	evenService.saveEvent(event);
    	byte[] image = event.getPhoto();
    	res.setContentType("image/jpeg");
    	try {
    	FileCopyUtils.copy(image, res.getOutputStream());
    	}catch(Exception e) {e.printStackTrace();}
    }
    
   
}
