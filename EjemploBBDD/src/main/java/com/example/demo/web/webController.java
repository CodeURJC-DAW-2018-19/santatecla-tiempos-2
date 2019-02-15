package com.example.demo.web;

import java.util.Optional;
import com.example.demo.Entidades.CategoriasController;
import com.example.demo.Entidades.Eventos;
import com.example.demo.Entidades.EventosController;
import com.example.demo.Entidades.TiempoController;
import com.example.demo.Users.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class webController {
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
            model.addAttribute("profesor",userComponent.getLoggedUser().getRol().contains("ROLE_PROFESOR"));
            model.addAttribute("userName",userComponent.getLoggedUser().getUsername());
        }
    }

    //Mostrar Eventos,Categorias y Tiempos
    @GetMapping("/")
    public String showEvents(Model model){
        model.addAttribute("eventos",eveControl.findAll());
        return "practicaDAW";
    }

    @GetMapping("/Categorias/{id}")
    public String showEvents(Model model,@PathVariable long id){
        Optional<Eventos>event=service.findOne(id);

        if(event.isPresent()){
            model.addAttribute("evento",event.get());
        }
        return "evento";
    }

    @GetMapping("/")
    public String showCategories(Model model){
        model.addAttribute("categorias",catcontrol.findAll());
        return "practicaDAW";
    }

    @GetMapping("/")
    public String showTime(Model model){
        model.addAttribute("time",timeControl.findAll());
        return "practicaDAW";
    }
}
