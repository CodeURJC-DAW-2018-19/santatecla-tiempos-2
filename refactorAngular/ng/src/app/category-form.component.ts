import {Component} from "@angular/core";
import {Router,ActivatedRoute} from "@angular/router";
import {Category,CategoryService} from "./category.service";

@Component({
  templateUrl:'category-form.component.html',
})
export class CategoryFormComponent{
  newCategory:boolean;
  category:Category;

  constructor(private _router:Router,activatedRoute:ActivatedRoute,private service:CategoryService){
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
    _ =>{},(error:Error)=>console.error('error creating new category: '+error),);
    window.history.back();
  }
}
