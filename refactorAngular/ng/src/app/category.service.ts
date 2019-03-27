import {Injectable} from "@angular/core";
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {LoginService}from "./auth/login.service";

export interface Category {
  id?:number;
  nameCategory:string;
}

const URL='/api/categories/';

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
      'Content-Type': 'application/json',
    });
    console.log(category);

    if(!category.id){
      return this.http
        .post<Category>(URL,body,{headers})
        .pipe(catchError((error)=>this.handleError(error)));
    }else{
      return this.http
        .put<Category>(URL+category.id,{headers})
        .pipe(catchError((error)=>this.handleError(error)));
    }
  }

  removeCategory(category:Category):Observable<Category>{
    return this.http
      .delete<Category>(URL+category.id)
      .pipe(catchError((error)=>this.handleError(error)));
  }

  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+ '): '+error);
  }
}
