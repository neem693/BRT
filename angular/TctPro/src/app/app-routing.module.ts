import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { JoinComponent } from './member/join/join.component';
import { JoinSuccessComponent } from './member/join-success/join-success.component';
import { LoginComponent } from './member/login/login.component';
import { AddWorksComponent } from './works/add-works/add-works.component';
import { AfterWorksSaveCheckComponent } from './works/after-works-save-check/after-works-save-check.component';
import { ArtistAddComponent } from './artist/artist-add/artist-add.component';
import { AfterArtistSaveCheckComponent } from './artist/after-artist-save-check/after-artist-save-check.component';
import { AddEvalComponent } from './eval/add-eval/add-eval.component';
import { WorkSerachComponent } from './works/work-serach/work-serach.component';
import { ArtistSearchComponent } from './artist/artist-search/artist-search.component';
import { ArtistDetailComponent } from './artist/artist-detail/artist-detail.component';


const routes: Routes = [

  {path:"home",component:HomeComponent},
  {path:"member",children:[
    {path:"join",component:JoinComponent},
    {path:"join_success/:id",component:JoinSuccessComponent},
    {path:"login",component:LoginComponent}
  ]},
  {path:"works",children:[
    {path:"addWork",component:AddWorksComponent},
    {path:"addWork/:id",component:AddWorksComponent},
    {path:"worksSaveCheck/:id",component:AfterWorksSaveCheckComponent},
    {path:"search/:id",component:WorkSerachComponent},
  ]},
  {path:"artist",children:[
    {path:"addArtist", component:ArtistAddComponent},
    {path:"addArtist/:id", component:ArtistAddComponent}, 
    {path:"artistSaveCheck/:id",component:AfterArtistSaveCheckComponent},
    {path:"searchArtist",component:ArtistSearchComponent},
    {path:"artistDetail/:id/:type",component:ArtistDetailComponent},
  ]},
  {path:"eval",children:[
    {path:"addEval/:id", component:AddEvalComponent}
  ]},
  {path:"**",redirectTo:"home"},
  {path:"",component:HomeComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
