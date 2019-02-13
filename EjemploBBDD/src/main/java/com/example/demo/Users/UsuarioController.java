package com.example.demo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UsuarioController {
    /*Conectamos con el repositorio del usuario*/
    @Autowired
    private UsuarioRepositorio userRep;

    /*Añadir usuarios*/
    @PostMapping(value ="/usuarios/{id")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario newUser(@RequestBody Usuario user){
        userRep.save(user);
        return user;
    }
}
