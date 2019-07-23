import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MyServiceService } from '../my-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private myservice:MyServiceService) {
    this.myservice.title = "Home"; 
    console.log("home change");
  }

  ngOnInit() {
    
  }

  

}
