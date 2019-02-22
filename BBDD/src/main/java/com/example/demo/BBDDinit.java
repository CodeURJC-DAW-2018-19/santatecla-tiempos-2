package com.example.demo;


import com.example.demo.entities.*;
import com.example.demo.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BBDDinit {
    @Autowired
    private CategoryRepository catRep;
    @Autowired
    private EventRepository eveRep;
    @Autowired
    private TimeRepository timeRep;
    @Autowired
    private UserRepository userRep;

    @PostConstruct
    public void init() {
        //Eventos,tiempo y categorias
        Category cat1 = new Category("Examenes");
        Category cat2 = new Category("Practicas");
        Category cat3 = new Category("Apuntes");
        catRep.save(cat1);
        catRep.save(cat2);
        catRep.save(cat3);


        Event event1=new Event("DAW","7/7/2019","hola");
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
