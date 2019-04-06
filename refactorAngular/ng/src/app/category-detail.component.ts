import {Component} from "@angular/core";
import {ActivatedRoute,Router} from "@angular/router";
import { TdDialogService } from '@covalent/core';
import {Category,CategoryService} from "./category.service";
import {LoginService} from "./auth/login.service";

@Component({
  templateUrl:'category-detail.component.html',
})

export class CategoryDetailComponent{
  category:Category;

  constructor(private router:Router,activatedRoute:ActivatedRoute,public service:CategoryService,public loginService:LoginService, private _dialogService: TdDialogService){
    const id=activatedRoute.snapshot.params['id'];
    service.getCategory(id).subscribe((category)=>(this.category=category),(error)=>console.error(error));
  }

  removeCategory(){

    this._dialogService.openConfirm({
      message: 'Borrar categoria',
      title: 'Confirm',
      width: '500px',
      height: '175px'
    }).afterClosed().subscribe((accept: boolean) => {
      if (accept) {
        this.service
            .removeCategory(this.category)
            .subscribe((_) => this.router.navigate(['/categories']), (error) => console.error(error));
      }
    });
  }
  editCategory(){
    console.log("dime que quieres editar");
    this.router.navigate(['/categories/edit',this.category.id]);

  }

  goToCategories(){
    this.router.navigate(['/categories']);
  }
}
