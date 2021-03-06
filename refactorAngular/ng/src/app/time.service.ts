import {Injectable} from "@angular/core";
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {LoginService}from "./auth/login.service";
import {Event, EventService} from "./event.service";
import {Category} from "./category.service";



export interface Time{
    id?:number;
    nameInterval:string;
    startDate:string;
    endDate:string;
    //subintervals:string;

    events: Event[] | number [];
}

const URL = '/api/times/';
const ALL='/api/times/all/';

@Injectable()
export class TimeService{
    constructor(private loginService:LoginService,private eventService:EventService,private http:HttpClient){}

    getTimes():Observable<Time[]>{
        console.log("Entrando en getTimes");
        return this.http.get<any>(URL,{withCredentials:true})
            .pipe(
                map(result=>result.content),
                catchError((error)=>this.handleError(error)));
    }

    getTime(id:number|string):Observable<Time>{
        return this.http.get<Time>(URL+id,{withCredentials:true})
            .pipe(catchError((error)=>this.handleError(error)));
    }

    saveTime(time:Time):Observable<Time>{
        const body=JSON.stringify(time);
        const headers=new HttpHeaders({'Content-Type':'application/json'});
        console.log(time);

        if(!time.id){
            return this.http.post<Time>(URL,body,{headers}).pipe(catchError((error)=>this.handleError(error)));
        }else{

            return this.http.put<Time>(URL+time.id,body,{headers})
                .pipe(
                    catchError((error)=>this.handleError(error)
                    ));
            console.log("Actualizo");
        }
    }

    removeTime(time:Time):Observable<Time>{
        return this.http.delete<Time>(URL+time.id).pipe(catchError((error)=>this.handleError(error)));
    }


    getTimesbyPage(page:number):Observable<Time[]>{
        console.log("pidiendo datos");
        return this.http.get<any>(URL+ "?page="+page,{withCredentials:true})
            .pipe(
                map(result => result.content),
                catchError((error)=>this.handleError(error)));
    }

    getCategory(){
        this.eventService.getCategory();
    }

    private handleError(error:any){
        console.error(error);
        return Observable.throw('Server error ('+error.status+' ): '+error);
    }

    getCountTime(){
        return     this.http.get<Time[]>(ALL,{withCredentials:true})
            .pipe(
                map(result => result.length),
                catchError((error)=>this.handleError(error)));

    }
}

