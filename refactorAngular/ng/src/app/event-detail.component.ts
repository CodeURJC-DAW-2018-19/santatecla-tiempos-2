import {Component} from "@angular/core";
import {ActivatedRoute,Router} from "@angular/router";
import {TdDialogService} from "@covalent/core";
import {Event,EventService} from "./event.service";
import {LoginService} from "./auth/login.service";
import {Category,CategoryService} from "./category.service";

@Component({
    templateUrl:'event-detail.component.html',
})

export class EventDetailComponent{
    event:Event;
   category:Category;

    constructor(private router:Router,activatedRoute:ActivatedRoute,public service:EventService,public loginService:LoginService, private _dialogService:TdDialogService,private categoryService:CategoryService){
        const id=activatedRoute.snapshot.params['id'];

        service.getEvent(id).subscribe((event=>this.event=event),(error)=>console.error(error));

    }

    removeEvent(){
        this._dialogService.openConfirm({
            message:'Borrar Evento',
            title:'Confirm',
            width:'500px',
            height:'175px'
        }).afterClosed().subscribe((accept:boolean)=>{
            if(accept){
                this.service.removeEvent(this.event).subscribe((_)=>this.router.navigate(['/events']),(error) => console.error(error));

            }
        });
    }

    editEvent(){
        this.router.navigate(['/events/edit',this.event.id]);

    }

    goToEvents(){
        this.router.navigate(['/events']);
    }
}