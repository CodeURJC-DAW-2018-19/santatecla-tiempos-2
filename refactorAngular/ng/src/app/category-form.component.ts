import {Component} from "@angular/core";
import {Router,ActivatedRoute} from "@angular/router";
import {Category,CategoryService} from "./category.service";
import {LoginService} from "./auth/login.service";
import {CategoryListComponent} from "./category-list.component";


@Component({
  templateUrl:'category-form.component.html',
})
export class CategoryFormComponent{
  newCategory:boolean;
  category:Category;

  constructor(private _router:Router,activatedRoute:ActivatedRoute,private service:CategoryService, private loginService:LoginService){
    const id=activatedRoute.snapshot.params['id'];
    if(id){
      service.getCategory(id).subscribe((category)=>(this.category=category),(error)=>console.error(error));
      this.newCategory=false;
    }else{
      this.category={nameCategory:''};
      this.newCategory=true;
    }
  }

  cancel(){
    window.history.back();
  }

  save(){
    this.service.saveCategory(this.category).subscribe(
    _ =>{},(error:Error)=>console.error('error creating new categories: '+error));
    window.history.back();
  }
}
