import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderSelectorComponent } from './header_footer/header-selector/header-selector.component';
import { FooterSelectorComponent } from './header_footer/footer-selector/footer-selector.component';
import { HomeComponent } from './home/home.component';
import { MatInputModule,MatFormFieldModule, MatIconModule, MatButtonModule, MatDialogModule } from '@angular/material';
import { JoinComponent, customVali } from './member/join/join.component';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { JoinFailComponent } from './member/dialog/join-fail/join-fail.component';
import { MemberServiceService } from './member/member-service.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service'
import { AuthInterceptor } from './HttpInterceptor/AuthInterceptor';

@NgModule({
  declarations: [
    AppComponent,
    HeaderSelectorComponent,
    FooterSelectorComponent,
    HomeComponent,
    JoinComponent,
    JoinFailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    HttpClientModule
  ],
  entryComponents: [
    JoinFailComponent
  ],
  providers: [
    CookieService,
    MemberServiceService,
    customVali,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
