package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserController {
    /*User repository connection*/
    @Autowired
    private UserRepository userRep;

    /*Add user*/
    @PostMapping(value ="/usuarios/{id")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user){
        userRep.save(user);
        return user;
    }
}
