package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.users.UserComponent;

public class WebController {
	
	@Autowired
	    private UserComponent userComponent;
	 
	@ModelAttribute
    public void addUserToModel(Model model){
        boolean logged=userComponent.getLoggedUser()!=null;
        model.addAttribute("logged",logged);
        if(logged){
            model.addAttribute("admin",userComponent.getLoggedUser().getRol().contains("ROLE_ADMIN"));
            model.addAttribute("userName",userComponent.getLoggedUser().getUsername());
            model.addAttribute("logged");
        }
    }
}
