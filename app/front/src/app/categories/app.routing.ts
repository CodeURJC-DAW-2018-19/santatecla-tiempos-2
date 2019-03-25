import {Routes,RouterModule} from "@angular/router";
import {CategoriesListComponent} from "./categories-list.component";

const appRoutes=[
  {path:'category',component:CategoriesListComponent},
  {path: '',redirectTo:'category',pathMatch:'full'}
]

export const routing=RouterModule.forRoot(appRoutes);
