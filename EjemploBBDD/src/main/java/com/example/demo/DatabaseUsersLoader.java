package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepositorio userRep;

    @PostConstruct
    private void initDatabase(){
      userRep.save(new Usuario("user","pass","student"));
      userRep.save(new Usuario("admin","password","admin"));
    }
}
