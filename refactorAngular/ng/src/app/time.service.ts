import {Injectable} from "@angular/core";
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {LoginService}from "./auth/login.service";
import {Event, EventService} from "./event.service";


export interface Time{
    id?:number;
    nameInterval:string;
    startDate:string;
    endDate:string;
    events:string;
    subintervals:string;
}

const URL = '/api/times/'

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
        const headers=new HttpHeaders({'Content-Type':'application/json',});
        console.log(event);

        if(!time.id){
            return this.http.post<Time>(URL,body,{headers}).pipe(catchError((error)=>this.handleError(error)));
        }else{
            return this.http.put<Time>(URL+time.id,body,{headers}).pipe(catchError((error)=>this.handleError(error)));
        }
    }

    removeTime(time:Time):Observable<Time>{
        return this.http.delete<Time>(URL+time.id).pipe(catchError((error)=>this.handleError(error)));
    }


    private handleError(error:any){
        console.error(error);
        return Observable.throw('Server error ('+error.status+' ): '+error);
    }
}

