package com.example.demo;


import com.example.demo.entities.*;
import com.example.demo.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @PostConstruct
    public void init() {
        //Eventos,tiempo y categorias
        Category cat1 = new Category("Examenes");
        Category cat2 = new Category("Practicas");
        Category cat3 = new Category("Apuntes");
        catRep.save(cat1);
        catRep.save(cat2);
        catRep.save(cat3);


        Event event1=new Event("DAW","7-7-2019", "Aulario 1", "hola");
        Event event2 = new Event("Seguridad", "20-12-18", "Aulario 1", "muy seguro");
        Event event3 = new Event("Java", "1-1-19", "Aulario 2", "No huele");
        
        eveRep.save(event1);
        eveRep.save(event2);
        eveRep.save(event3);
        
        event1.getCategorias().add(cat1);

   
        Time time1 = new Time("Intervalo 1", "5-7-2018", "1-1-2020");
        Time time2 = new Time("Intervalo 2", "2-1-2020", "1-3-2020");
        Time time3 = new Time("Intervalo 3", "2-4-2021", "2-5-2021");
        
        time1.getEvents().add(event1);
        time1.getEvents().add(event2);
        time1.getEvents().add(event3);
        
        
        subTime subtime1 = new subTime ("2018", "8-9-2018", "10-10-2018");
        subTime subtime2 = new subTime ("2019", "10-1-2019", "20-11-2019");
        
        
        
        time1.getSubIntervals().add(subtime1);
        time1.getSubIntervals().add(subtime2);
        
        timeRep.save(time1);
        timeRep.save(time2);
        timeRep.save(time3);

        //usuarios
        userRep.save(new User("User",passEncoder.encode("pass"),"ROLE_USER"));
        userRep.save(new User("Marcos",passEncoder.encode("pass"),"ROLE_USER"));
        userRep.save(new User("admin",passEncoder.encode("pass"),"ROLE_USER","ROLE_ADMIN"));
        
        
    }
}
