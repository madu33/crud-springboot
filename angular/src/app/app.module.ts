import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './componet/customer/customer.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {GlobalErrorHandler} from "./exception/GlobalErrorHandler";

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot({
      timeOut: 2500,
      progressAnimation: 'increasing',
    }), // ToastrModule added
    FormsModule
  ],
  providers: [GlobalErrorHandler],
  bootstrap: [AppComponent]
})
export class AppModule { }
