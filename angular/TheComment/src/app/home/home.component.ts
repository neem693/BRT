import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MyServiceService } from '../my-service.service';
import { CommonData } from '../common/common-data';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title:string;

  constructor(private myservice:MyServiceService,private commonData:CommonData) {
    commonData.title = "Home"; 
    
    console.log("home change");
  }

  ngOnInit() {

    this.myservice.title.subscribe(x=> this.title = x);
    this.myservice.changeTitle('Home');
   
    
  }

  

}
