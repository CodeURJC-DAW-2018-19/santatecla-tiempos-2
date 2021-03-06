import {Component,ViewChild,TemplateRef} from "@angular/core";
import {Router} from "@angular/router";
import {LoginService} from "./auth/login.service";
import {MatDialog,MatDialogRef} from "@angular/material";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
})

export class LoginComponent{
  @ViewChild('loginDialog')loginDialog:TemplateRef<any>;
  dialogRef:MatDialogRef<any,any>;

  constructor(public dialog:MatDialog,public router:Router,public loginService:LoginService){}

  login(event:any,user:string,pass:string){
    event.preventDefault();
    this.loginService.login(user, pass).subscribe((u)=> {
      console.log(u);
      this.dialogRef.close();
    },
      (error)=>alert('Invalid user or password'),
    );
  }

  logout(){
    this.loginService.logout().subscribe(
      (response)=>{
        this.router.navigate(['/']);
      },
      (error)=>console.log("Error when try logout" +error),
    );
  }

  openLoginDialog(){
    this.dialogRef=this.dialog.open(this.loginDialog,{
      width:'50%',
      height:'50%',
    });
  }
}
