import {Component,OnInit} from "@angular/core";
import {Router} from "@angular/router";

import {Category,CategoryService} from"./category.service";
import {LoginService} from "./auth/login.service";

@Component({
  templateUrl:'category-list.component.html'
})

export class CategoryListComponent implements OnInit{
  categories:Category[];

  constructor(private router:Router,private service:CategoryService,public loginService:LoginService) {

  }

  ngOnInit(){
    console.log("pidiendo datos");
    this.service.getCategories().subscribe(
      categories=>this.categories=categories,
      error=>console.log(error)
    );
  }

  newCategory(){
    this.router.navigate(['/category/new'])
  }
}
