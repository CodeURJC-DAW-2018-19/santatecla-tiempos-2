package com.example.demo.web;

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

@Controller()
public class WebController {
    @Autowired
    private CategoriasController catcontrol;
    @Autowired
    private EventosController eveControl;
    @Autowired
    private TiempoController timeControl;
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

    //Mostrar Eventos,Categorias y Tiempos
    //Categorias
    @GetMapping("/")
    public String showEvents(Model model){
        model.addAttribute("eventos",catcontrol.findAll());
        return "practicaDAW";
    }

    @GetMapping("/Categorias/{id}")
    public String showEvents(Model model,@PathVariable long id){
        Optional<Categorias> cat=catcontrol.finOne(id);

        if(cat.isPresent()){
            model.addAttribute("evento",cat.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newCategory")
    public String saveCategory(Model model,Categorias category){
        catcontrol.save(category);
        return "practicaDAW";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PathVariable long id){
        catcontrol.delete(id);
        return "practicaDAW";
    }


    //Eventos
    @GetMapping("/")
    public String showCategories(Model model){
        model.addAttribute("categorias",catcontrol.findAll());
        return "practicaDAW";
    }


    @GetMapping("/Eventos/{id}")
    public String showCategories(Model model, @PathVariable long id){
        Optional<Eventos> event=eveControl.findOne(id);
        if(event.isPresent()){
            model.addAttribute("evento", event.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newEvent")
    public String saveEvent(Model model,Eventos event){
        eveControl.save(event);
        return "practicaDAW";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(Model model,@PathVariable long id){
    	
        eveControl.delete(id);
        return "practicaDAW";
    }

    //Tiempos
    @GetMapping("/")
    public String showTime(Model model){
        model.addAttribute("time",timeControl.findAll());
        return "practicaDAW";
    }
}
