import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderSelectorComponent } from './header_footer/header-selector/header-selector.component';
import { FooterSelectorComponent } from './header_footer/footer-selector/footer-selector.component';
import { HomeComponent } from './home/home.component';
import { MatInputModule,MatFormFieldModule, MatIconModule, MatButtonModule, MatDialogModule, MatMenuModule, MatSelectModule, MatCardModule, MatExpansionModule, MatCheckboxModule, MatDatepickerModule, MatNativeDateModule, MAT_DATE_LOCALE, MAT_DATE_FORMATS, MatProgressSpinnerModule } from '@angular/material';
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
import { AddEvalComponent } from './eval/add-eval/add-eval.component';
import { MatterSelectDialogComponent } from './eval/dialog/matter-select-dialog/matter-select-dialog.component';
import { EvalService } from './eval/eval.service';
import {SwiperConfigInterface, SwiperModule, SwiperConfig} from 'ngx-swiper-wrapper';
import { WorkSerachComponent } from './works/work-serach/work-serach.component';
import { ArtistSearchComponent } from './artist/artist-search/artist-search.component';
import { ArtistDetailComponent } from './artist/artist-detail/artist-detail.component';
import { EvalSerachComponent } from './eval/eval-serach/eval-serach.component';
import { EvalDetailComponent } from './eval/eval-detail/eval-detail.component';
import { GlobalDialogComponent } from './global/dialog/global-dialog/global-dialog.component';
import {StoreModule} from '@ngrx/store'
import { usuerInfoReducer } from './ngrx/reducer/userInfoReducer';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { SnsJoinComponent } from './member/sns-join/sns-join.component';
import { HomeService } from './home/home.service';

const DEFAULT_SWIPER_CONFIG: SwiperConfigInterface = {
  direction: 'horizontal',
  slidesPerView: 4,

};

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
    AddEvalComponent,
    MatterSelectDialogComponent,
    WorkSerachComponent,
    ArtistSearchComponent,
    ArtistDetailComponent,
    EvalSerachComponent,
    EvalDetailComponent,
    GlobalDialogComponent,
    SnsJoinComponent,

    
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
    MatProgressSpinnerModule,
    SwiperModule,
    StoreModule.forRoot({userInfo:usuerInfoReducer}),
    StoreDevtoolsModule.instrument({
      maxAge: 25, // Retains last 25 states
      //logOnly: environment.production, // Restrict extension to log-only mode
    }),
  ],
  entryComponents: [
    JoinFailComponent,
    LoginFailComponent,
    AddArtistDialogComponent,
    WorksAddComponent,
    WorksNameIsExistDialogComponent,
    ArtNameIsExistDialogComponent,
    MatterSelectDialogComponent,
    GlobalDialogComponent
  ],
  providers: [
    CookieService,
    MemberServiceService,
    WorksSerivceService,
    ArtistService,
    EvalService,
    HomeService,
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
    {
      provide:SwiperConfig,
      useValue:DEFAULT_SWIPER_CONFIG,
    },
    // {
    //   provide:MAT_DATE_FORMATS,
    //   useValue:
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
