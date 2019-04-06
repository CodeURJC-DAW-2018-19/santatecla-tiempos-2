import {Component, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";

import {Category,CategoryService} from"./category.service";
import {LoginService} from "./auth/login.service";
import {IPageChangeEvent, TdPagingBarComponent} from "@covalent/core";

@Component({
  templateUrl:'category-list.component.html'
})

export class CategoryListComponent implements OnInit{
  categories:Category[];
  searchCategory:string;
  p:number=0;
  event:IPageChangeEvent;
  pageNumber:number;
  pageChanged:boolean;
  firstLast:boolean;
  pageSize:number=5;
  total:number=40;

  constructor(private router:Router,private service:CategoryService,public loginService:LoginService) {

  }

  ngOnInit(){
    console.log("pidiendo datos");
    this.service.getCategories().subscribe(
      categories=>this.categories=categories,
      error=>console.log(error)
    );
    this.service.getCountCategories().subscribe(
        categories=>this.total=categories,
        error=>console.log(error));
  }

  ngDoCheck(){
    if(this.pageChanged){
      this.service.getCategoriesbyPage(this.pageNumber-1).subscribe(
          categories=>this.categories=categories,
          error=>console.log(error)
      );
      this.service.getCountCategories().subscribe(
          categories=>this.total=categories,
          error=>console.log(error));
      this.pageChanged=false;
    }

  }

  change(event: IPageChangeEvent): void {
    this.event = event;
    this.pageNumber = event.page;
    this.pageChanged = true;
  }

  toggleFirstLast(): void {
    this.firstLast = !this.firstLast;
  }

  getCategoriesbyPage(page:number){
    this.service.getCategoriesbyPage(page).subscribe(
        categories=>this.categories=categories,
        error=>console.log(error)
    );
    this.p= page;
  }


  newCategory(){
    this.router.navigate(['/categories/new']);
  }



  @ViewChild(TdPagingBarComponent) paging: TdPagingBarComponent;

}
