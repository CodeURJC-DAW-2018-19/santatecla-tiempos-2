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
        //Categories
        Category cat1 = new Category("Examenes");
        Category cat2 = new Category("Practicas");
        Category cat3 = new Category("Apuntes");
        catRep.save(cat1);
        catRep.save(cat2);
        catRep.save(cat3);
        for(int i=0;i<37;i++){
            catRep.save(new Category("Categoria1"+i));
        }
        
        //Events
        Event event1=  new Event("DAW","7-7-2019","Aulario 1","Aulario 1" );
        Event event2 = new Event("Seguridad", "20-12-18","Aulario 1", "Aulario 1");
        Event event3 = new Event("Java", "1-1-19","Aulario 2", "Aulario 2");
        Event event4=  new Event("DAW","7-7-2019","Aulario 1", "Aulario 1");
        Event event5 = new Event("Seguridad", "20-12-18","Aulario 1", "Aulario 1");
        Event event6 = new Event("Java", "1-1-19","Aulario 2", "Aulario 2");
        Event event7 = new Event("Javaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event8 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event9 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event10 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event11 = new Event("Javaaa", "1-1-19","Aulario3", "Aulario 2");
        

        event1.getCategories().add(cat1);
        eveRep.save(event1);
        eveRep.save(event2);
        eveRep.save(event3);
        eveRep.save(event4);
        eveRep.save(event5);
        eveRep.save(event6);
        eveRep.save(event7);
        eveRep.save(event8);
        eveRep.save(event9);
        eveRep.save(event10);
        eveRep.save(event11);


        //Times
        Time time1 = new Time("Intervalo 1", "5-7-2018", "1-1-2020");
        Time time2 = new Time("Intervalo 2", "2-1-2020", "1-3-2020");
        Time time3 = new Time("Intervalo 3", "2-4-2021", "2-5-2021");
        Time time4 = new Time("Intervalo 4", "5-7-2018", "1-1-2020");
        Time time5 = new Time("Intervalo 5", "2-1-2020", "1-3-2020");
        Time time6 = new Time("Intervalo 6", "2-4-2021", "2-5-2021");
        Time time7 = new Time("Intervalo 7", "2-4-2021", "2-5-2021");
        Time time8 = new Time("Intervalo 8", "2-4-2021", "2-5-2021");
        Time time9 = new Time("Intervalo 9", "2-4-2021", "2-5-2021");
        Time time10 = new Time("Intervalo 10'", "2-4-2021", "2-5-2021");

       time1.getEvents().add(event1);
        time1.getEvents().add(event2);
        time1.getEvents().add(event3);
        
        
        SubTime subtime1 = new SubTime ("2018", "8-9-2018", "10-10-2018");
        SubTime subtime2 = new SubTime ("2019", "10-1-2019", "20-11-2019");
        
        
        
        time1.getSubIntervals().add(subtime1);
        time1.getSubIntervals().add(subtime2);
        
        timeRep.save(time1);
        timeRep.save(time2);
        timeRep.save(time3);
        timeRep.save(time4);
        timeRep.save(time5);
        timeRep.save(time6);
        timeRep.save(time7);
        timeRep.save(time8);
        timeRep.save(time9);
        timeRep.save(time10);

        //Users
        userRep.save(new User("User",passEncoder.encode("pass"),"ROLE_USER"));
        userRep.save(new User("Marcos",passEncoder.encode("pass"),"ROLE_USER"));
        userRep.save(new User("admin",passEncoder.encode("pass"),"ROLE_USER","ROLE_ADMIN"));
        
        
    }
}
