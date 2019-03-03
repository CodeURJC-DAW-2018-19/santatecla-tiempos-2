package com.example.demo.web;


import com.example.demo.entities.*;
import com.example.demo.users.UserComponent;
import com.example.demo.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    
    //Page
    @RequestMapping("/categories")
    public String categories(@PageableDefault(value =5) Pageable pageable, Model model){
        Page<Category>categories=service.findAll(pageable);
        model.addAttribute("categories",categories);

        model.addAttribute("showNext",!categories.isLast());
        model.addAttribute("showPrev",!categories.isFirst());
        model.addAttribute("numPage",categories.getNumber());
        model.addAttribute("prevPage",categories.getNumber()+1);
        model.addAttribute("nextPage",categories.getNumber()-1);
        model.addAttribute("categories",service.findAll(pageable));
        return "categories";
    }
    
   /* @RequestMapping("/categories")
    public String categories(Model model){
    	model.addAttribute("categories",service.findAll());
    	return "categories";
    }*/
    

    @GetMapping("/newCategory")
    public String saveCategory(Model model){
    	model.addAttribute("categories",service.findAll());
        return "categories";
    }

    @PostMapping("/newCategory")
    public String saveCategory(Model model,@RequestParam String catName,@PageableDefault(value =5) Pageable pageable){
        Category category = new Category(catName);
        service.saveCategory(category);
        Page<Category>categories=service.findAll(pageable);
        model.addAttribute("categories",categories);

        model.addAttribute("showNext",!categories.isLast());
        model.addAttribute("showPrev",!categories.isFirst());
        model.addAttribute("numPage",categories.getNumber());
        model.addAttribute("prevPage",categories.getNumber()+1);
        model.addAttribute("nextPage",categories.getNumber()-1);
        model.addAttribute("categories",service.findAll(pageable));
        return "categories";
    }
    
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PageableDefault(value =10) Pageable pageable) {
    	model.addAttribute("categories", service.findAll());
        return "categories";
    }
    
    
    @PostMapping("/deleteCategory/{id}")
    public String deleteCategory(Model model,@PathVariable long id,@PageableDefault(value =5) Pageable pageable){
        service.deleteCategory(id);
        Page<Category>categories=service.findAll(pageable);
        model.addAttribute("categories",categories);

        model.addAttribute("showNext",!categories.isLast());
        model.addAttribute("showPrev",!categories.isFirst());
        model.addAttribute("numPage",categories.getNumber());
        model.addAttribute("prevPage",categories.getNumber()+1);
        model.addAttribute("nextPage",categories.getNumber()-1);
        model.addAttribute("categories",service.findAll(pageable));
        return "categories";
    }
    
    @GetMapping("{id}/updateCategory")
    public String updateCategory(Model model) {
    	model.addAttribute("categories", service.findAll());
        return "categories";
    }

    @PostMapping("{id}/updateCategory")
    public String updateCategory(Model model,@PathVariable long id, @RequestParam String category,@PageableDefault(value =5) Pageable pageable) {
    	Category categ = service.findOne(id).get();
    	categ.setNameCategory(category);
    	service.saveCategory(categ);
        Page<Category>categories=service.findAll(pageable);
        model.addAttribute("categories",categories);

        model.addAttribute("showNext",!categories.isLast());
        model.addAttribute("showPrev",!categories.isFirst());
        model.addAttribute("numPage",categories.getNumber());
        model.addAttribute("prevPage",categories.getNumber()+1);
        model.addAttribute("nextPage",categories.getNumber()-1);
        model.addAttribute("categories",service.findAll(pageable));
        return "categories";
    }

}
