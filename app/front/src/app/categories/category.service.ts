import {Injectable} from "@angular/core";

export class Category{
  constructor(public id:number,public nameCategory:string){}
}

@Injectable()
export class CategoryService{
  private categories=[
    new Category(1,"Deportes"),
    new Category(2,"Apuntes"),
    new Category(3,"Huelgas")

  ];



  getCategories(){
    return this.categories;
  }
  getCategory(id:number|string){
    return this.categories.find(category=>category.id===+id);
  }
}
