import { Component } from '@angular/core';
import { Router } from '@angular/router';

declare const $:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TctPro';

  constructor(router:Router){

    router.events.subscribe((x)=>{
      setTimeout(()=>{
        if($('.hr_01').hasClass('active') == false){
        $('.hr_01').addClass('active');
        console.log(11);
      }},500)
      
    })

  }

}
