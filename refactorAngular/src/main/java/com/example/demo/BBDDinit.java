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
        event1.setHasImage(true);
        event1.setEncodedImage("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");
        Event event2 = new Event("Seguridad", "20-12-18","Aulario 1", "Aulario 1");
        Event event3 = new Event("Java", "1-1-19","Aulario 2", "Aulario 2");
       /* Event event4=  new Event("DAW","7-7-2019","Aulario 1", "Aulario 1");
        Event event5 = new Event("Seguridad", "20-12-18","Aulario 1", "Aulario 1");
        Event event6 = new Event("Java", "1-1-19","Aulario 2", "Aulario 2");
        Event event7 = new Event("Javaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event8 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event9 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event10 = new Event("Javaaa", "1-1-19","Aulario 3", "Aulario 2");
        Event event11 = new Event("Javaaa", "1-1-19","Aulario3", "Aulario 2");*/
        

        //event1.getCategories().add(cat1);
        eveRep.save(event1);
        eveRep.save(event2);
        eveRep.save(event3);
       /* eveRep.save(event4);
        eveRep.save(event5);
        eveRep.save(event6);
        eveRep.save(event7);
        eveRep.save(event8);
        eveRep.save(event9);
        eveRep.save(event10);
        eveRep.save(event11);*/


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
