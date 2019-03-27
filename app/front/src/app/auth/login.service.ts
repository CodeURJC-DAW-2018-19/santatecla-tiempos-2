import {Injectable} from "@angular/core";
import {HttpClient,HttpHeaders,HttpErrorResponse} from "@angular/common/http";
import {map} from "rxjs/operators";
import {utf8Encode} from "@angular/compiler/src/util";

const URL = '/api';

export interface User {
  id?:number;
  userName:string;
  rol:string[];

}

@Injectable()
export class LoginService{
  isLogged=false;
  isAdmin=false;
  user:User;
  auth:string;

  constructor(private http:HttpClient){
    this.reqIsLogged();
  }

  getAuth(){
    return this.auth;
  }

  reqIsLogged():void{
    const headers=new HttpHeaders({
      'X-Requested-With': 'XMLHttpRequest',
      "Content-Type": "application/json",
      "Access-Control-Allow-Credentials": "true",
      "Access-Control-Allow-Origin": "*",
      "Cache-Control": "no-cache"
    });

    this.http.get(URL+'/login',{withCredentials:true,headers}).subscribe(
      (response:User)=>this.processLogInResponse(response),(error:HttpErrorResponse)=>{
        if (error.status !== 401){
          console.error('Error when asking if logged: '+JSON.stringify(error));
        }
      },
    );
  }

  private processLogInResponse(response:User){
    this.isLogged=true;
    this.user=response;
    this.isAdmin=this.user.rol.indexOf('ROLE_ADMIN')!==-1;
  }

  logIn(user:string,pass:string){
    console.log('user: '+user+' pass:'+pass);
    this.auth='Basic '+utf8Encode(user+':'+pass);
    const headers=new HttpHeaders({
      Authorization:this.auth,
      'X-Requested-With': 'XMLHttpRequest',
      "Content-Type": "application/json",
      "Access-Control-Allow-Credentials": "true",
      "Access-Control-Allow-Origin": "*",
      "Cache-Control": "no-cache"
    });
    return this.http.get(URL+'/login',{withCredentials:true,headers}).pipe(map((response:User)=>{
      this.processLogInResponse(response);
      return this.user;
    }),
    );
  }

  logOut(){
    return this.http.get(URL+'/logout',{withCredentials:true}).pipe(
      map((response)=>{
        this.isLogged=false;
        this.isAdmin=false;
        return response;
      }),
    );
  }

  private setCurrentUser(user: User) {
    this.isLogged = true;
    this.user = user;
    this.isAdmin = this.user.rol.indexOf('ROLE_ADMIN') !== -1;
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
    this.isLogged = false;
    this.isAdmin = false;
  }
}


