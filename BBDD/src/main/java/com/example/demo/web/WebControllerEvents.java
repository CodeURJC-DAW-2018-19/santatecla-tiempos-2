package com.example.demo.web;

import com.example.demo.entities.*;
import com.example.demo.photos.Decoder;
import com.example.demo.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

@Controller
public class WebControllerEvents extends WebController {
	
	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "img");
	private Map<Long, Image> images = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void init() throws IOException {

		if (!Files.exists(FILES_FOLDER)) {
			Files.createDirectories(FILES_FOLDER);
		}
	}

    @Autowired PhotoService foto;

    @Autowired
    private EventService evenService;
    
    @Autowired
    private CategoryService catService;

    @GetMapping("/events")
    public String showEvents(@PageableDefault(value =5) Pageable pageable, Model model){
        Page<Event> events=evenService.findAll(pageable);

        model.addAttribute("events",evenService.findAll());
        model.addAttribute("categoryList", catService.findAll());

        model.addAttribute("events",events);
        model.addAttribute("showNext",!events.isLast());
        model.addAttribute("showPrev",!events.isFirst());
        model.addAttribute("numPage",events.getNumber());
        model.addAttribute("prevPage",events.getNumber()+1);
        model.addAttribute("nextPage",events.getNumber()-1);
        model.addAttribute("events",evenService.findAll(pageable));
        return "events";
    }




    @RequestMapping("/events/list")
    public String eventsList(@PageableDefault(value =5) Pageable pageable, Model model) {

        Page<Event> event = evenService.findAll(pageable);
        model.addAttribute("events", evenService.findAll(pageable));
        return "eventsList";

    }

    @GetMapping("/newEvent")
    public String saveEvent(Model model){
    	model.addAttribute("events",evenService.findAll());
        return "events";
    }

    @PostMapping("/newEvent")
    public String saveEvent(@PageableDefault(value =5) Pageable pageable, Event event,Model model, @RequestParam("file") MultipartFile file){
    	long id = event.getId();
    	String fileName = "image-" + id + ".jpg";
    	if(!file.isEmpty()) {
    		try {
    			event.setPhoto(file.getBytes());
    			event.setEncodedImage(Base64.encode(file.getBytes()));
    			event.setHasImage(true);
    		}catch(IOException ioe) {ioe.printStackTrace();}
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
    public String deleteEvent(Model model,@PathVariable long id,@PageableDefault(value =5) Pageable pageable) {
    	evenService.deleteEvent(id);
        Page<Event> events=evenService.findAll(pageable);

        model.addAttribute("events",evenService.findAll());
        model.addAttribute("categoryList", catService.findAll());

        model.addAttribute("events",events);
        model.addAttribute("showNext",!events.isLast());
        model.addAttribute("showPrev",!events.isFirst());
        model.addAttribute("numPage",events.getNumber());
        model.addAttribute("prevPage",events.getNumber()+1);
        model.addAttribute("nextPage",events.getNumber()-1);
        model.addAttribute("events",evenService.findAll(pageable));
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
    
    @PostMapping("/updateEvent/{id}")
    public String updateEvent(@PageableDefault(value =5) Pageable pageable,Model model, @PathVariable long id, @RequestParam String nameEvent, @RequestParam String eventDate, @RequestParam String eventLoc, @RequestParam String wikiUrl, @RequestParam String selectedCatUpdate) {
    	Event event = evenService.findOne(id).get();
    	if(!nameEvent.equals("")) {
    		event.setNameEvent(nameEvent);
    	}
    	if(!eventDate.equals("")) {
    		event.setDate(eventDate);
    	}
    	if(!eventLoc.equals("")) {
    		event.setLocation(eventLoc);
    	}
    	/*if(!photoUrl.equals("")) {
    		event.setPhoto(photoUrl);
    	}*/
    	if(!wikiUrl.equals("")) {
    		event.setWiki(wikiUrl);
    	}
    	if(!selectedCatUpdate.equals("")) {
    		event.getCategories().clear();
    		String[] catSplitted= selectedCatUpdate.split(",");
    		for(int i = 0; i< catSplitted.length; i++) {
    			List<Category> c = catService.findByName(catSplitted[i]);
    			event.getCategories().add(c.get(0));
    		}
    	}
    	evenService.saveEvent(event);
        Page<Event> events=evenService.findAll(pageable);

        model.addAttribute("events",evenService.findAll());
        model.addAttribute("categoryList", catService.findAll());

        model.addAttribute("events",events);
        model.addAttribute("showNext",!events.isLast());
        model.addAttribute("showPrev",!events.isFirst());
        model.addAttribute("numPage",events.getNumber());
        model.addAttribute("prevPage",events.getNumber()+1);
        model.addAttribute("nextPage",events.getNumber()-1);
        model.addAttribute("events",evenService.findAll(pageable));
        return "events";
    }
    
    


}
