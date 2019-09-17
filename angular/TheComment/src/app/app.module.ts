import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {ScrollDispatchModule} from '@angular/cdk/scrolling'
import {DragDropModule} from '@angular/cdk/drag-drop'
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { MatButtonModule, MatMenuModule, MatSidenavModule, MatDatepicker, MatInputModule, MatNativeDateModule, MatDatepickerModule,MAT_DATE_LOCALE,MAT_DATE_FORMATS } from '@angular/material'
import {MatMomentDateModule} from '@angular/material-moment-adapter'
import { PipeModule } from './pipe/pipe-module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'

import { AppRoutingModule,RoutingComponent } from './app-routing.module';

import {FormsModule,ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { NewCmpComponent } from './new-cmp/new-cmp.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';

import { MyServiceService } from './my-service.service'
import {AlbumFetchService} from './album-fetch.service'
import { AuthService } from './auth/auth.service';

import { ChangeTextDirective } from './change-text.directive';

import { KoreaDateFormat } from './utill/my_utill';

import { CommonData } from './common/common-data';
import { ViewProductComponent } from './product/view-product/view-product.component';
import { AddProductComponent } from './product/add-product/add-product.component';
import { ProductServiceService } from './product/product-service.service';
import { WebSocketComponent } from './web-socket/web-socket.component';
import { LoginComponent } from './auth/login/login.component';
import { AuthInterceptor } from './httpInterceptor/authInterceptor';




//test

@NgModule({
  declarations: [
    AppComponent,
    NewCmpComponent,
    ChangeTextDirective,
    HomeComponent,
    ContactUsComponent,
    RoutingComponent,
    ViewProductComponent,
    AddProductComponent,
    WebSocketComponent,
    LoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ScrollDispatchModule,
    DragDropModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatMenuModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatMomentDateModule,
    PipeModule,
    NgbModule
    
],
  providers: [MyServiceService,
              AlbumFetchService,
              CommonData,
              ProductServiceService,
              AuthService,
              {provide:MAT_DATE_LOCALE,useValue:'ko'},
            {provide:MAT_DATE_FORMATS,useValue:KoreaDateFormat},
            {provide:HTTP_INTERCEPTORS,
            useClass:AuthInterceptor,
            multi:true
            }],

  bootstrap: [AppComponent]
})
export class AppModule { }
