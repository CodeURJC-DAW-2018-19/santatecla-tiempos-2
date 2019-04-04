import {Component} from "@angular/core";
import {Time, TimeService} from "./time.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "./auth/login.service";
import {TdDialogService} from "@covalent/core";

@Component({
    templateUrl:'time-detail.component.html',
})
export class TimeDetailComponent{
    time:Time;
    events:Event;

    constructor(private router:Router,activatedRoute:ActivatedRoute,public service:TimeService,public loginService:LoginService, private _dialogService: TdDialogService){
        const id=activatedRoute.snapshot.params['id'];
        service.getTime(id).subscribe((time=>this.time=time),(error)=>console.error(error));
    }
    removeTime(){
        this._dialogService.openConfirm({
            message: 'Borrar intervalo',
            title: 'Confirm',
            width: '500px',
            height: '175px'
        }).afterClosed().subscribe((accept: boolean) =>{
            if(accept){
                this.service
                    .removeTime(this.time)
                    .subscribe(( )=>this.router.navigate(['/times']), (error)=>console.error(error));

            }

        });

    }
    editTime(){
        console.log("dime que quieres editar");
        this.router.navigate(['/times/edit',this.time.id]);
    }
    goToTimes(){
        this.router.navigate(['/times']);
    }
}