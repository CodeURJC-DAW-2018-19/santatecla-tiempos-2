import {Routes,RouterModule} from "@angular/router";
import {CategoryListComponent} from "./category-list.component";
import {CategoryFormComponent} from "./category-form.component";
import {CategoryDetailComponent} from "./category-detail.component";

const appRoutes=[
  {path:'categories',component:CategoryListComponent,useAsDefault:true},
  {path:'categories/new',component:CategoryFormComponent},
  {path:'categories/:id',component:CategoryDetailComponent},
  {path:'categories/edit/:id',component: CategoryFormComponent},
  {path: '',redirectTo:'category',pathMatch:'full'}
]

export const routing=RouterModule.forRoot(appRoutes);
