import {Component} from "@angular/core";
import {Category,CategoryService} from "./category.service";

@Component({
  template:`
   <h2>CATEGORIAS</h2>
   <ul>
        <li *ngFor="let Category of categories">
            <a [routerLink]="['/category',Category.id]">{{Category.id}}-{{Category.nameCategory}}</a>
        </li>
    </ul>    
  `
})

export class CategoriesListComponent{
  categories:Category[];

  constructor(service:CategoryService) {
    this.categories=service.getCategories();
  }

}
