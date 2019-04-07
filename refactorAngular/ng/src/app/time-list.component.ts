import {Component, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";
import {LoginService} from "./auth/login.service";
import {Time, TimeService} from "./time.service";
import {IPageChangeEvent, TdPagingBarComponent} from "@covalent/core";

@Component({
    templateUrl:'time-list.component.html'
})

export class TimeListComponent implements OnInit{
    times:Time[];
    events:Event[];
    p:number=0;


    event:IPageChangeEvent;
    pageNumber:number;
    pageChanged:boolean;
    firstLast:boolean;
    pageSize:number=5;
    total:number=10;

    constructor(private router:Router,private service:TimeService,public loginService:LoginService){}
    ngOnInit() {
        console.log("Pidiendo datos ngOnInit de tiempos");
        this.service.getTimes().subscribe(
            times=>this.times=times,
            error=>console.log(error)
        );
        this.service.getCountTime().subscribe(
            times=>this.total=times,
            error=>console.log(error));
    }

    newTime(){
        this.router.navigate(['/times/new'])
    }

    getTimesbyPage(page:number){
        this.service.getTimesbyPage(page).subscribe(
            ti=>this.times=ti,
            error=>console.log(error)
        );
        this.p= page;
    }

    ngDoCheck(){
        if(this.pageChanged){
            this.service.getTimesbyPage(this.pageNumber-1).subscribe(
                times=>this.times=times,
                error=>console.log(error)
            );
            this.service.getCountTime().subscribe(
                times=>this.total=times,
                error=>console.log(error));
            this.pageChanged=false;
        }

    }

    change(event: IPageChangeEvent): void {
        this.event = event;
        this.pageNumber = event.page;
        this.pageChanged = true;
    }

    toggleFirstLast(): void {
        this.firstLast = !this.firstLast;
    }

    @ViewChild(TdPagingBarComponent) paging: TdPagingBarComponent;

}
