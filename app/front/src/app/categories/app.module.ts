import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from './app.component';

import {FormsModule} from "@angular/forms";
import { HttpModule, JsonpModule } from '@angular/http';

import {CategoryService} from "./category.service";
import {routing} from "./app.routing";
import {CategoriesListComponent} from "./categories-list.component";



@NgModule({
  declarations: [
    AppComponent,
    CategoriesListComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    routing



  ],
  providers: [CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
