import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { AppComponent } from './app.component';
import { DomSanitizer } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { HttpModule, JsonpModule } from '@angular/http';
import { NgxChartsModule } from '@swimlane/ngx-charts';
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
import {LoginService} from "./auth/login.service";
import {LoginComponent} from "./login.component";
import {CategoryListComponent} from "./category-list.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule, Routes} from "@angular/router";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {ErrorInterceptor} from "./auth/error.interceptor";
import {BasicAuthInterceptor} from "./auth/auth.interceptor";
import {EventService} from "./event.service";
import {EventListComponent} from "./event-list.component";
import {EventFormComponent} from "./event-form.component";
import {EventDetailComponent} from "./event-detail.component";


const appRoutes:Routes=[
  {path:'categories',component:CategoryListComponent},
  {path:'events',component:EventListComponent},
];

@NgModule({

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
   RouterModule.forRoot(appRoutes,{enableTracing:true}),//debug
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
    NgxChartsModule,
    routing,



  ],
  providers: [CategoryService,LoginService,EventService,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: LocationStrategy, useClass: HashLocationStrategy }],
  bootstrap: [AppComponent],
  declarations:[AppComponent,
    CategoryFormComponent,
    CategoryDetailComponent,
    LoginComponent,
    CategoryListComponent,
    EventListComponent,
    EventFormComponent,
    EventDetailComponent],
})
export class AppModule {
  constructor(private matIconRegistry: MatIconRegistry, private domSanitizer: DomSanitizer) {
    matIconRegistry.addSvgIconSet(domSanitizer.bypassSecurityTrustResourceUrl('/assets/symbol-defs.svg'));
  }
}
