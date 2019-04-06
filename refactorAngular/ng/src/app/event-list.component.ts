import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Event,EventService} from "./event.service";
import {LoginService} from "./auth/login.service";
import {Category,CategoryService} from "./category.service";

/*Aqui elegimos los template y los archivos de maquetacion que vamos a usar*/
@Component({
    templateUrl:'event-list.component.html'
})

/*Creamos la clase de EventListComponent que se encargara coger los datos necesarios*/
export class  EventListComponent implements OnInit{
    events:Event[];
    //categories:Category[];
    p: number = 0;
    searchEvent:string;
    constructor(private router:Router,private service:EventService,public loginService:LoginService,private categoryService:CategoryService){}

    ngOnInit() {
        console.log("Pidiendo datos ngOnInit de eventos");
        this.service.getEventsbyPage(0).subscribe(
            events=>this.events=events,
            error=>console.log(error)
        );
    }

    getEventsbyPage(page:number){
        this.service.getEventsbyPage(page).subscribe(
            categories=>this.events=categories,
            error=>console.log(error)
        );
        this.p= page;
    }

    newEvent(){
        this.router.navigate(['/events/new']);
    }
}
