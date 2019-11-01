import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderSelectorComponent } from './header_footer/header-selector/header-selector.component';
import { FooterSelectorComponent } from './header_footer/footer-selector/footer-selector.component';
import { HomeComponent } from './home/home.component';
import { MatInputModule,MatFormFieldModule, MatIconModule, MatButtonModule, MatDialogModule, MatMenuModule, MatSelectModule, MatCardModule, MatExpansionModule, MatCheckboxModule, MatDatepickerModule, MatNativeDateModule, MAT_DATE_LOCALE, MAT_DATE_FORMATS } from '@angular/material';
import {MatMomentDateModule} from '@angular/material-moment-adapter'
import { DragDropModule } from '@angular/cdk/drag-drop'
import { JoinComponent, customVali } from './member/join/join.component';
import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { JoinFailComponent } from './member/dialog/join-fail/join-fail.component';
import { MemberServiceService } from './member/member-service.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service'
import { AuthInterceptor } from './HttpInterceptor/AuthInterceptor';
import { JoinSuccessComponent } from './member/join-success/join-success.component';
import { AddWorksComponent } from './works/add-works/add-works.component';
import { LoginComponent } from './member/login/login.component';
import { LoginFailComponent } from './member/dialog/login-fail/login-fail.component';
import { AddArtistDialogComponent } from './works/dialog/add-artist-dialog/add-artist-dialog.component';
import { WorksSerivceService } from './works/works-serivce.service';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import { AfterWorksSaveCheckComponent } from './works/after-works-save-check/after-works-save-check.component';
import { ArtistAddComponent } from './artist/artist-add/artist-add.component';
import { WorksAddComponent } from './artist/dialog/works-add/works-add-diaolog.component';
import { ArtistService } from './artist/artist.service';
import { AfterArtistSaveCheckComponent } from './artist/after-artist-save-check/after-artist-save-check.component';
import { WorksNameIsExistDialogComponent } from './works/dialog/works-name-is-exist-dialog/works-name-is-exist-dialog.component';
import { ArtNameIsExistDialogComponent } from './artist/dialog/art-name-is-exist-dialog/art-name-is-exist-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderSelectorComponent,
    FooterSelectorComponent,
    HomeComponent,
    JoinComponent,
    JoinFailComponent,
    JoinSuccessComponent,
    AddWorksComponent,
    LoginComponent,
    LoginFailComponent,
    AddArtistDialogComponent,
    AfterWorksSaveCheckComponent,
    ArtistAddComponent,
    WorksAddComponent,
    AfterArtistSaveCheckComponent,
    WorksNameIsExistDialogComponent,
    ArtNameIsExistDialogComponent,

    
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
    HttpClientModule,
    MatMenuModule,
    MatSelectModule,
    MatCardModule,
    DragDropModule,
    MatExpansionModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatMomentDateModule,
    NgbPaginationModule,
  ],
  entryComponents: [
    JoinFailComponent,
    LoginFailComponent,
    AddArtistDialogComponent,
    WorksAddComponent,
    WorksNameIsExistDialogComponent,
    ArtNameIsExistDialogComponent,
  ],
  providers: [
    CookieService,
    MemberServiceService,
    WorksSerivceService,
    ArtistService,
    customVali,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    {
      provide:MAT_DATE_LOCALE,
      useValue:'ko'
    },
    // {
    //   provide:MAT_DATE_FORMATS,
    //   useValue:
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
