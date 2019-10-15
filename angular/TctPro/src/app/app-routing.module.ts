import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { JoinComponent } from './member/join/join.component';
import { JoinSuccessComponent } from './member/join-success/join-success.component';
import { LoginComponent } from './member/login/login.component';


const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"member",children:[
    {path:"join",component:JoinComponent},
    {path:"join_success/:id",component:JoinSuccessComponent}
    {path:"login",component:LoginComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
