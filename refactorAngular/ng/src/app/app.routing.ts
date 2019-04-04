import {Routes,RouterModule} from "@angular/router";
import {CategoryListComponent} from "./category-list.component";
import {CategoryFormComponent} from "./category-form.component";
import {CategoryDetailComponent} from "./category-detail.component";
import {EventListComponent} from "./event-list.component";
import {EventFormComponent} from "./event-form.component";
import {EventDetailComponent} from "./event-detail.component";
import {TimeListComponent} from "./time-list.component";
import {TimeFormComponent} from "./time-form.component";
import {TimeDetailComponent} from "./time-detail.component";

const appRoutes=[
    //Rutas usadas para categorias
  {path:'categories',component:CategoryListComponent,useAsDefault: true },
  {path:'categories/new',component:CategoryFormComponent},
  {path:'categories/:id',component:CategoryDetailComponent},
  {path:'categories/edit/:id',component: CategoryFormComponent},
  //{path:'categories/:nameCategory',component:CategoryListComponent},
  //rutas usadas para eventos
  {path:'events',component:EventListComponent},
  {path:'events/new',component:EventFormComponent},
  {path:'events/edit/:id',component:EventFormComponent},
  {path:'events/:id',component:EventDetailComponent},
  //{path:'/events/:nameEvent',component:EventListComponent},
  {path:'times',component:TimeListComponent},
  {path:'times/new',component:TimeFormComponent},
  {path:'times/edit/:id',component:TimeFormComponent},
  {path:'times/:id',component:TimeDetailComponent},
  //ruta usada por defecto a la hora de abrir la pagina
  {path: '',redirectTo:'categories',pathMatch:'full'}
];

export const routing=RouterModule.forRoot(appRoutes);
