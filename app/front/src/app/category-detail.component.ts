import {Component} from "@angular/core";
import {ActivatedRoute,Router} from "@angular/router";

import {Category,CategoryService} from "./category.service";
import {LoginService} from "./auth/login.service";

@Component({
  templateUrl:'category-detail.component.html',
})

export class CategoryDetailComponent{
  category:Category;

  constructor(private router:Router,activatedRoute:ActivatedRoute,public service:CategoryService,public loginService:LoginService){
    const id=activatedRoute.snapshot.params['id'];
    service.getCategory(id).subscribe((category)=>this.category=category),(error)=>console.error(error);
  }

  removeCategory(){
    const okResponse=window.confirm("Borrar categoria");
    if(okResponse){
      this.service.removeCategory(this.category).subscribe((_)=>this.router.navigate(['/category']),)
    }
  }
  editCategory(){
    this.router.navigate(['/category/edit',this.category.id]);
  }

  goToCategories(){
    this.router.navigate(['/category']);
  }
}
