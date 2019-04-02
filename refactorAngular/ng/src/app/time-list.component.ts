import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {LoginService} from "./auth/login.service";
import {Time, TimeService} from "./time.service";

@Component({
    templateUrl:'time-list.component.html'
})

export class TimeListComponent implements OnInit{
    times:Time[];

    constructor(private router:Router,private service:TimeService,public loginService:LoginService){}
    ngOnInit() {
        console.log("Pidiendo datos ngOnInit de eventos");
        this.service.getTimes().subscribe(
            times=>this.times=times,
            error=>console.log(error)
        );
    }

    newTime(){
        this.router.navigate(['/times/new'])
    }
}