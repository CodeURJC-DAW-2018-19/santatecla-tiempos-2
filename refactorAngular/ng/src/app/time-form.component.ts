import {Component,OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Time,TimeService} from "./time.service";
import {EventService,Event} from "./event.service";
import {Category} from "./category.service";

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
                this.time = {nameInterval: '',startDate:'',subintervals:'',endDate:'',event:[]};
                this.newTime = true;
            }
    }
    cancel(){
        window.history.back();
    }
    save(){
        this.service.saveTime(this.time).subscribe(
            _ =>{},(error:Error)=>console.error('error creating new time: '+error),);
        window.history.back();
    }


    private eventss:Event[];
    ngOnInit(){
        console.log("pidiendo datos de select para el formulario");
        this.eventService.getAllEvents().subscribe(
            eve =>this.eventss = eve,
            error => console.log(error)
        );
    }

    set  selectedEvent(id: number) {
        this.time.event = [id];
    }




}