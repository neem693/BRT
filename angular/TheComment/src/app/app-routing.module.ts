import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ViewProductComponent } from './product/view-product/view-product.component';
import { AddProductComponent } from './product/add-product/add-product.component';
import { WebSocketComponent } from './web-socket/web-socket.component';


const routes: Routes = [
  {path:"Home/home", component:HomeComponent},
  {path:"ContactUs",component:ContactUsComponent},
  {path:"product",children:[
    {path:'',component:ViewProductComponent},
    {path:'view',component:ViewProductComponent},
    {path:'addProduct',component:AddProductComponent},
    
  ]},
  {path:"WebSocket",component:WebSocketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent = [HomeComponent,ContactUsComponent];
