import {Injectable}from "@angular/core";
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError,map} from "rxjs/operators";
import {LoginService} from "./auth/login.service";
import {Category, CategoryService} from "./category.service";


/*Creamos los datos que va a necesitar la clase*/
export interface Event{
    id?:number;
    nameEvent:string;
    date:string;
    location:string;
    wiki:string;
    hasImage:boolean;
    category:string;

}

/*Añadimos URL con una variable constante que sea la usada en la api*/
const URL='/api/events/';

/*Creamos el Injectable con lo necesario para servicio*/
@Injectable()
export class EventService{
    /*Constructor con lo que vamos a necesitar*/
    constructor(private loginService:LoginService,private categoryService:CategoryService,private http:HttpClient){}



    getEvents():Observable<Event[]>{
        console.log("Entrando en getEvents");
        return this.http.get<any>(URL,{withCredentials:true})
            .pipe(
                map(result=>result.content),
                catchError((error)=>this.handleError(error)));
    }

    getEvent(id:number|string):Observable<Event>{
        return this.http.get<Event>(URL+id,{withCredentials:true})
            .pipe(catchError((error)=>this.handleError(error)));
    }

    saveEvent(event:Event):Observable<Event>{
        const body=JSON.stringify(event);
        const headers=new HttpHeaders({'Content-Type':'application/json',});
        console.log(event);

        if(!event.id){
            return this.http.post<Event>(URL,body,{headers}).pipe(catchError((error)=>this.handleError(error)));
        }else{
            return this.http.put<Event>(URL+event.id,body,{headers}).pipe(catchError((error)=>this.handleError(error)));
        }
    }

    removeEvent(event:Event):Observable<Event>{
        return this.http.delete<Event>(URL+event.id).pipe(catchError((error)=>this.handleError(error)));
    }

    getCategory(){
        this.categoryService.getCategories();
    }

    private handleError(error:any){
        console.error(error);
        return Observable.throw('Server error ('+error.status+' ): '+error);
    }

}
