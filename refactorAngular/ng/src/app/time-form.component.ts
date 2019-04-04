import {Component,OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Time,TimeService} from "./time.service";
import {EventService,Event} from "./event.service";


@Component({
    templateUrl: 'time-form.component.html',
})
export class TimeFormComponent implements OnInit{
    newTime: boolean;
    time: Time;
    event:Event[];
    constructor(private _router:Router, activatedRoute: ActivatedRoute, private service:TimeService,private  eventService:EventService){
        const id = activatedRoute.snapshot.params['id'];
            if (id){
                service.getTime(id).subscribe((time)=> (this.time=time),(error)=>console.error(error));
                this.newTime=false;
            }else {
                this.time = {nameInterval: '',startDate:'',endDate:'',event:[id]};
                this.newTime = true;
            }
    }
    cancel(){
        window.history.back();
    }
    save(){
        this.service.saveTime(this.time).subscribe(
            _ =>{},(error:Error)=>console.error('Error creating new time: '+error));
        window.history.back();
    }


    private alleventss:Event[];
    ngOnInit(){
        console.log("pidiendo datos de select para el formulario");
        this.eventService.getAllEvents().subscribe(
            eve =>this.alleventss = eve,
            error => console.log(error)
        );
    }

    set  selectedEvent(id: number) {
        this.time.event= [id];
    }




}