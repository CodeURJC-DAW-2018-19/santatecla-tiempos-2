import {Routes,RouterModule} from "@angular/router";
import {CategoryListComponent} from "./category-list.component";
import {CategoryFormComponent} from "./category-form.component";
import {CategoryDetailComponent} from "./category-detail.component";

const appRoutes=[
  {path:'category',component:CategoryListComponent,useAsDefault:true},
  {path:'category/new',component:CategoryFormComponent},
  {path:'category/:id',component:CategoryDetailComponent},
  {path: '',redirectTo:'category',pathMatch:'full'}
]

export const routing=RouterModule.forRoot(appRoutes);