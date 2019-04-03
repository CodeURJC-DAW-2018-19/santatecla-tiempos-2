import {Event,EventService} from "./event.service";
import {Component,OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Category,CategoryService} from"./category.service";

@Component({
    templateUrl:'event-form.component.html',
})

export class EventFormComponent implements OnInit{
    newEvent:boolean;
    event:Event;
    constructor(private _router:Router,activatedRoute:ActivatedRoute,private service:EventService,private categoryService:CategoryService){
        const id=activatedRoute.snapshot.params['id'];

        if(id){
            console.log(service.getEvent(id).subscribe((event) => this.event = event), (error) => console.error(error));
            this.newEvent=false;
        }else{
            this.event={nameEvent:'',date:'',location:'',wiki:'',hasImage:false,category:[]};
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
/*
    getCat(){
        this.categoryService.getCategories();
    }*/

   private categories:Category[];
    ngOnInit(){

        console.log("pidiendo datos de select para el formulario");
        this.categoryService.getCategories().subscribe(
            categories=>this.categories=categories,
            error=>console.log(error)
        );
    }

}