import {Component,OnInit} from "@angular/core";
import {Router} from "@angular/router";

import {Category,CategoryService} from"./category.service";
import {LoginService} from "./auth/login.service";

@Component({
  templateUrl:'category-list.component.html'
})

export class CategoryListComponent implements OnInit{
  private page: number =1;
  categories:Category[];
  pages:Array<number>;
  searchCategory:string;

  constructor(private router:Router,private service:CategoryService,public loginService:LoginService) {

  }

  setCategoryPage(i,event:any){
    event.preventDefault();
    this.page = i;
    this.getCategories();
  }

  ngOnInit(){
    console.log("pidiendo datos");
    this.getCategories();
  }

  getCategories(){
    this.service.getCategories(this.page).subscribe(
        data=>{
            console.log(data);
            this.categories = data['content'];
            this.pages= new Array(data['totalPages']);
        },
        (error)=>{
          console.log(error.error.message);
        }
    );
  }

  newCategory(){
    this.router.navigate(['/categories/new'])
  }



}
