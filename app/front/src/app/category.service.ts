import {Injectable} from "@angular/core";
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {LoginService}from "./login.service";

export interface Category {
  id?:number;
  nameCategory:string;
}

const URL="https://localhost:8080/api/categories/";

@Injectable()
export class CategoryService{
  constructor(private loginService:LoginService,private http:HttpClient) {}

  getCategories():Observable<Category[]>{
    return this.http.get<Category[]>(URL,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }

  getCategory(id:number|string):Observable<Category>{
    return this.http.get<Category>(URL+id,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }

  saveCategory(category:Category):Observable<Category>{
    const body=JSON.stringify(category);
    const headers=new HttpHeaders({
      Authorization:this.loginService.getAuth(),
      'X-Requested-With': 'XMLHttpRequest',
      'Content-Type': 'application/json',
      'Access-Control-Allow-Credentials': 'true',
      'Access-Control-Allow-Origin': '*',
      'Cache-Control': 'no-cache',
    });
    console.log(category);

    if(!category.id){
      return this.http
        .post<Category>(URL,body,{headers,withCredentials:true})
        .pipe(catchError((error)=>this.handleError(error)));
    }else{
      return this.http
        .put<Category>(URL+category.id,{headers,withCredentials:true})
        .pipe(catchError((error)=>this.handleError(error)));
    }
  }

  removeCategory(category:Category):Observable<Category>{
    const headers=new HttpHeaders({
      Authorization:this.loginService.getAuth(),
      'X-Requested-With': 'XMLHttpRequest',
      'Access-Control-Allow-Credentials': 'true',
      'Access-Control-Allow-Origin': '*',
      'Cache-Control': 'no-cache',
    });

    return this.http
      .delete<Category>(URL+category.id,{headers,withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }

  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+ '): '+error);
  }
}
