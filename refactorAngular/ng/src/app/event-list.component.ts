import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Event,EventService} from "./event.service";
import {LoginService} from "./auth/login.service";

/*Aqui elegimos los template y los archivos de maquetacion que vamos a usar*/
@Component({
    templateUrl:'event-list.component.html'
})

/*Creamos la clase de EventListComponent que se encargara coger los datos necesarios*/
export class  EventListComponent implements OnInit{
    events:Event[];
    displayedColumns: string[] = ['position', 'name', 'date', 'place','wiki'];
    dataSource = this.events;
    constructor(private router:Router,private service:EventService,public loginService:LoginService){}

    ngOnInit() {
        console.log("Pidiendo datos ngOnInit de eventos");
        this.service.getEvents().subscribe(
            events=>this.events=events,
            error=>console.log(error)
        );
    }

    newEvent(){
        this.router.navigate(['/event/new']);
    }
}