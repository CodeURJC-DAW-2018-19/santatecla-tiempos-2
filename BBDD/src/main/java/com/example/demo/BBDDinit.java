package com.example.demo;


import com.example.demo.Entidades.*;
import com.example.demo.Users.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BBDDinit {
    @Autowired
    private CategoriasRepositorio catRep;
    private EventoRepositorio eveRep;
    private TimeRepository timeRep;
    private UserRepository userRep;

    @PostConstruct
    public void init() {
        //Eventos,tiempo y categorias
        Categorias cat1 = new Categorias("Examenes");
        Categorias cat2 = new Categorias("Practicas");
        Categorias cat3 = new Categorias("Apuntes");
        catRep.save(cat1);
        catRep.save(cat2);
        catRep.save(cat3);


        Eventos event1=new Eventos("DAW","7/7/2019","hola");
        event1.getCategorias().add(cat1);

        /*
        Tiempo time1 = new Tiempo("Intervalo 1", "5/7/2018", "1/1/2020");
        time1.getEventos().add(event1);*/

        //usuarios
        userRep.save(new User("User","pass","ROLE_USER"));
        userRep.save(new User("Marcos","pass","ROLE_USER"));
        userRep.save(new User("admin","pass","ROLE_USER","ROLE_ADMIN"));
        
        
    }
}
