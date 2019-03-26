import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import {FormsModule} from "@angular/forms";
import { HttpModule, JsonpModule } from '@angular/http';

import {CategoryService} from "./category.service";
import {routing} from "./app.routing";
import {
  MatButtonModule,
  MatListModule,
  MatIconModule,
  MatCardModule,
  MatMenuModule,
  MatInputModule,
  MatButtonToggleModule,
  MatProgressSpinnerModule,
  MatSelectModule,
  MatSlideToggleModule,
  MatDialogModule,
  MatSnackBarModule,
  MatToolbarModule,
  MatTabsModule,
  MatSidenavModule,
  MatTooltipModule,
  MatRippleModule,
  MatRadioModule,
  MatGridListModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatSliderModule,
  MatAutocompleteModule,
} from '@angular/material';

import {
  CovalentCommonModule,
  CovalentLayoutModule,
  CovalentMediaModule,
  CovalentExpansionPanelModule,
  CovalentStepsModule,
  CovalentLoadingModule,
  CovalentDialogsModule,
  CovalentSearchModule,
  CovalentPagingModule,
  CovalentNotificationsModule,
  CovalentMenuModule,
  CovalentDataTableModule,
  CovalentMessageModule,
} from '@covalent/core';
import {CategoryFormComponent} from "./category-form.component";
import {CategoryDetailComponent} from "./category-detail.component";
import {LoginService} from "./login.service";
import {LoginComponent} from "./login.component";
import {CategoryListComponent} from "./category-list.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";


@NgModule({

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    RouterModule.forRoot([]),
    HttpClientModule,
    JsonpModule,
    /** Material Modules */
    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatInputModule,
    MatSelectModule,
    MatButtonToggleModule,
    MatSlideToggleModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatTabsModule,
    MatSidenavModule,
    MatTooltipModule,
    MatRippleModule,
    MatRadioModule,
    MatGridListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatAutocompleteModule,
    MatInputModule,
    /** Covalent Modules */
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentExpansionPanelModule,
    CovalentStepsModule,
    CovalentDialogsModule,
    CovalentLoadingModule,
    CovalentSearchModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentMenuModule,
    CovalentDataTableModule,
    CovalentMessageModule,
    /** Additional **/
    routing,



  ],
  providers: [CategoryService,LoginService],
  bootstrap: [AppComponent],
  declarations:[AppComponent,CategoryFormComponent,CategoryDetailComponent,LoginComponent,CategoryListComponent],
})
export class AppModule { }
