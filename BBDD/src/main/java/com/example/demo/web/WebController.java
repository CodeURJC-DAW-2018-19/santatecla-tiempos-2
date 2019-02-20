package com.example.demo.Web;


import com.example.demo.Entidades.*;
import com.example.demo.Users.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    private CategoriasService service;
    @Autowired
    private EventosService evenService;
    @Autowired
    private TiempoService timeService;
    @Autowired
    private UserComponent userComponent;


    @ModelAttribute
    public void addUserToModel(Model model){
        boolean logged=userComponent.getLoggedUser()!=null;
        model.addAttribute("logged",logged);
        if(logged){
            model.addAttribute("admin",userComponent.getLoggedUser().getRol().contains("ROLE_ADMIN"));
            model.addAttribute("userName",userComponent.getLoggedUser().getUsername());
        }
    }

    @GetMapping("/")
    public String showCategorias(Model model){
        model.addAttribute("categorias",service.findAll());
        return "practicaDAW";
    }

    @GetMapping("/Categorias/{id}")
    public String showEvents(Model model,@PathVariable long id){
        Optional<Categorias> cat=service.findOne(id);


        if(cat.isPresent()){
            model.addAttribute("evento",cat.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newCategory")
    public String saveCategory(Model model,Categorias category){
        service.save(category);
        return "practicaDAW";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PathVariable long id){
        service.delete(id);
        return "practicaDAW";
    }

    /*
    //Eventos
    @GetMapping("/")
    public String showEvents(Model model){
        model.addAttribute("eventos",evenService.findAll());
        return "practicaDAW";
    }


    @GetMapping("/Eventos/{id}")
    public String showCategories(Model model, @PathVariable long id){
        Optional<Eventos> event=evenService.findOne(id);
        if(event.isPresent()){
            model.addAttribute("evento", event.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,Eventos event){
        evenService.save(event);
        return "practicaDAW";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model,@PathVariable long id){

        evenService.delete(id);
        return "practicaDAW";
    }

    //Tiempos
    @GetMapping("/")
    public String showTime(Model model){
        model.addAttribute("time",timeService.findAll());
        return "practicaDAW";
    }*/
}
