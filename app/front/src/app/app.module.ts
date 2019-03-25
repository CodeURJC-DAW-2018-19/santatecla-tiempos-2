import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CategoriesListComponent} from "./categories/categories-list/categories-list.component";
import {CategoriesEditComponent} from "./categories/categories-edit/categories-edit.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule, JsonpClientBackend} from "@angular/common/http";
import {CategoriesService} from "./categories/shared/categories.service";



@NgModule({
  declarations: [
    AppComponent,
    CategoriesListComponent,
    CategoriesEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    JsonpClientBackend



  ],
  providers: [CategoriesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
