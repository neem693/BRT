import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-join-success',
  templateUrl: './join-success.component.html',
  styleUrls: ['./join-success.component.css']
})
export class JoinSuccessComponent implements OnInit {

  user_id_login:string;

  constructor(private route:ActivatedRoute) { }

  ngOnInit() {

    window.scrollTo(0,0);

    this.route.paramMap.subscribe((x)=>{
      this.user_id_login = x['params']["id"];
    })
    
  }

}
