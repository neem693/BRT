import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import * as $ from 'jquery';
//import * as cookie from 'js-cookie';
//import {Cookies} from 'js-cookie'


//declare const $:any;
declare const Cookies:any;





@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: any;
  token:any;

  constructor(private authService: AuthService) { }


  ngOnInit() {
    this.token = {
      'value':undefined
    }
    // this.formdata = new FormGroup({
    //   emailid: new FormControl("",Validators.compose([
    //       Validators.required,
    //       Validators.pattern( /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) <mailto:()\[\]\\.,;:\s@"]+(\.[^>
    //   ])),
    //   passwd: new FormControl("",this.pwdValidator)
    //   });

    this.loginData = new FormGroup({
      username: new FormControl("", Validators.compose([
        Validators.required
      ])),
      password: new FormControl("", Validators.compose([
        Validators.required
      ]))
    })



    this.authService.getToken().subscribe(
      (data)=>{
        // console.log(data);
        // this.token.value = data['value'];
        // this.token.load = true;
        // Cookies.set("JSESSIONID", data['sessionId']);
      },
      (error)=>{

      }
      )
  }

  loginFunction(data: any) {
   // this.token.value = Cookies.get("XSRF-TOKEN")
    //console.log(data);
    // let form_data = new FormData();

    // for (var key in data) {
    //   form_data.append(key, data[key]);
    // }
    //console.log(this.token.value);
   // form_data.append("_csrf",this.token.value);
    

    console.log(data);
    this.authService.login(data).subscribe(
      (next) => {
        console.log(next);
      }, (error) => {
        console.log(error);
      }
    )
  }

}
