package com.example.demo.web;


import com.example.demo.entities.*;
import com.example.demo.users.UserComponent;
import com.example.demo.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WebControllerCategories extends WebController {
    @Autowired
    private CategoryService service;

   


    
    
    @GetMapping("/")
    public String index() {
    	return "login2";
    }
    
    @RequestMapping("/categories")
    public String categories(Model model){
    	model.addAttribute("categories",service.findAll());
    	return "categories";
    }


    @GetMapping("/Categorias/{id}")
    public String showCategory(Model model,@PathVariable long id){
        Optional<Category> cat=service.findOne(id);


        if(cat.isPresent()){
            model.addAttribute("categorias",cat.get());
        }
        return "modalCategory";
    }

    @GetMapping("/newCategory")
    public String saveCategory(Model model){
    	model.addAttribute("categories",service.findAll());
        return "categories";
    }

    @PostMapping("/newCategory")
    public String saveCategory(Model model,@RequestParam String catName){
        Category category = new Category(catName);
        service.saveCategory(category);
        model.addAttribute("categories", service.findAll());
        return "categories";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PathVariable long id){
        service.deleteCategory(id);
        return "categories";
    }


}
