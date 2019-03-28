import {Event,EventService} from "./event.service";
import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    templateUrl:'event-form.component.html',
})

export class EventFormComponent{
    newEvent:boolean;
    event:Event;

    constructor(private _router:Router,activatedRoute:ActivatedRoute,private service:EventService){
        const id=activatedRoute.snapshot.params['id'];
        if(id){
            console.log(service.getEvent(id).subscribe((event) => this.event = event), (error) => console.error(error));
            this.newEvent=false;
        }else{
            this.event={nameEvent:'',date:'',location:'',wiki:'',hasImage:false};
            this.newEvent=true;
        }
    }

    cancel(){
        window.history.back();
    }

    save(){
        this.service.saveEvent(this.event).subscribe((event)=>{
            console.log('Event saved',event);
        },(error:Error)=>console.error('Error creating new event: '+error));
        window.history.back();
    }

}