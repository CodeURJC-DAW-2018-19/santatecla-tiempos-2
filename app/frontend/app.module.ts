import {HttpClientModule} from './daw/node_modules/@angular/common/http';
import {AppRoutingModule} from "./daw/src/app/app-routing.module";
import {AppComponent} from "./daw/src/app/app.component";
import { BrowserModule } from './daw/node_modules/@angular/platform-browser';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from './daw/node_modules/@angular/material';
import { FormsModule } from './daw/node_modules/@angular/forms';
import { OktaAuthModule } from './daw/@okta/okta-angular';

@NgModule({
    declarations:[
        appComponent
    ],
    imports:[
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        MatButtonModule,
        MatCardModule,
        MatInputModule,
        MatListModule,
        MatToolbarModule,
        FormsModule,
        OktaAuthModule.initAuth(config)
    ],
    providers:[{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
    boostrap:[AppComponent]
})
export class AppModule{}

