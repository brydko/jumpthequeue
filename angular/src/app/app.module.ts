import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoreModule } from './shared/core.module';
import { FormLoginComponent } from './form-login/form-login.component';
import { LoginComponent } from './form-login/components/login/login.component';
import { FormLoginModule } from './form-login/form-login-module';
import { HeaderComponent } from './layout/header/header.component';
import { RegisterComponent } from './register/register.component';
import { ViewQueueComponent } from './view-queue/view-queue.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HeaderComponent,
    ViewQueueComponent,
  ],
  imports: [
    BrowserModule,
    FormLoginModule,
    AppRoutingModule,
    CoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
