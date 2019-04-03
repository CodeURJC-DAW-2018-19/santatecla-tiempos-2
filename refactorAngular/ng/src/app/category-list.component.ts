import {Component,OnInit} from "@angular/core";
import {Router} from "@angular/router";

import {Category,CategoryService} from"./category.service";
import {LoginService} from "./auth/login.service";

@Component({
  templateUrl:'category-list.component.html'
})

export class CategoryListComponent implements OnInit{
  categories:Category[];
  searchCategory:string;
  p:number=0;

  constructor(private router:Router,private service:CategoryService,public loginService:LoginService) {

  }

  ngOnInit(){
    console.log("pidiendo datos");
    this.service.getCategories().subscribe(
      categories=>this.categories=categories,
      error=>console.log(error)
    );
  }

  getCategoriesbyPage(page:number){
    this.service.getCategoriesbyPage(page).subscribe(
        categories=>this.categories=categories,
        error=>console.log(error)
    );
    this.p= page;
  }


  newCategory(){
    this.router.navigate(['/categories/new'])
  }


}
