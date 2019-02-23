package com.example.demo.web;


import com.example.demo.entities.*;
import com.example.demo.users.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class WebControllerCategories extends WebController{
    @Autowired
    private CategoryService service;

   


    
    
    @GetMapping("/")
    public String index() {
    	return "login2";
    }
    
    @RequestMapping("/categories")
    public String categories(){
    	return "categories";
    }

   /* @GetMapping("/")
    public String showCategory(Model model){
        model.addAttribute("categorias",service.findAll());
        return "practicaDAW";
    }*/

    @GetMapping("/Categorias/{id}")
    public String showCategory(Model model,@PathVariable long id){
        Optional<Category> cat=service.findOne(id);


        if(cat.isPresent()){
            model.addAttribute("categorias",cat.get());
        }
        return "practicaDAW";
    }

    @PostMapping("/newCategory")
    public String saveCategory(Model model,Category category){
        service.saveCategory(category);
        return "practicaDAW";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PathVariable long id){
        service.deleteCategory(id);
        return "practicaDAW";
    }

    @RequestMapping("/login")
    public String login() {
    	return "login";
    }
    
    @RequestMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }


  @GetMapping("/login")
  public String login(Model model){
        model.addAttribute("hideLogin",true);
        return "login";
  }

  @GetMapping("/loginerror")
    public String loginError(){
        return "loginError";
  }
}
