import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData:any;

  constructor(private authService:AuthService) { }


  ngOnInit() {

    // this.formdata = new FormGroup({
    //   emailid: new FormControl("",Validators.compose([
    //       Validators.required,
    //       Validators.pattern( /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) <mailto:()\[\]\\.,;:\s@"]+(\.[^>
    //   ])),
    //   passwd: new FormControl("",this.pwdValidator)
    //   });
  
    this.loginData = new FormGroup({
      username: new FormControl("",Validators.compose([
        Validators.required
      ])),
      password: new FormControl("",Validators.compose([
        Validators.required
      ]))
    })
  }

  loginFunction(data:any){
    console.log(data);
    this.authService.login(data).subscribe(
      (next)=>{
        console.log(next);
      },(error)=>{
        console.log(error);
      }
    )
  }

}
