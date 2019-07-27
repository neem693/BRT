import { Component, OnInit,Input } from '@angular/core';

import { MyServiceService } from '../my-service.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  title:string;

  constructor(private myservice:MyServiceService) { }

  ngOnInit() {
    this.myservice.title.subscribe(x=> this.title = x );
    this.myservice.changeTitle('Contact Us');
  }

}
