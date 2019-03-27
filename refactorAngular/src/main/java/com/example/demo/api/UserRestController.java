package com.example.demo.api;


import com.example.demo.users.User;
import com.example.demo.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")

public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Collection<User> getUser(){
        return userService.findAll();
    }
}
