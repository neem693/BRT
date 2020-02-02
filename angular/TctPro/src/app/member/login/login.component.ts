import { Component, OnInit, ɵConsole } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { LoginFailComponent } from '../dialog/login-fail/login-fail.component';
import { MemberServiceService } from '../member-service.service';
import { CookieService } from 'ngx-cookie-service';
import * as moment from 'moment';
import { member_const } from '../member_const/member_cosnt';
import { Router } from '@angular/router';
import 'url-search-params-polyfill';
import { SNS } from 'src/const/publicConst';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: any;
  /** spin circle loading bar */
  loading ={
    login: 0
  }

  firebaseVar:any;

  constructor(private dialog: MatDialog,
    private memberService: MemberServiceService,
    private cookieService: CookieService,
    private router:Router) { }

  ngOnInit() {
    
   

    localStorage.removeItem(member_const.token_key);
    localStorage.removeItem(member_const.token_expire_key);

    this.loginData = {
      user_login_id: new FormControl("", {
        validators: Validators.compose([
          Validators.required,
        ])
      }),
      password: new FormControl("", Validators.compose([
        Validators.required,
      ])),

    }

  }
/**
 * snslogin 1 : sns 로그인 모드
 * undefined : 일반 모드
 */
  login_common(snslogin:any,additionalData:any) {
    console.log("login");
    let key: string;
    let data:any;
    if(snslogin == 1){
      data = additionalData;
    }else{
      data = this.loginData;
    }
   
    let param: URLSearchParams = new URLSearchParams();
    for (key in data) {

      if (data[key]['errors'] != null) {

        this.openAlert("아이디와 패스워드를 입력해주세요.");
        return;

      }
      if(snslogin == 1){
        param.append(key, data[key]);
      }else{
        param.append(key, data[key]['value']);
      }
     

    }

    param.append("grant_type", 'password');
    let paramData = param.toString();
    this.loading.login = 1;
    this.memberService.login_common(paramData).subscribe((x) => {
      
      let expire_sec = x["expires_in"];
      expire_sec += moment().unix();
      expire_sec -= 500;
      localStorage.setItem(member_const.token_key, x["access_token"]);
      localStorage.setItem(member_const.token_expire_key, expire_sec);
      let return_url = sessionStorage.getItem(member_const.loginReturnUrlKey);
      sessionStorage.removeItem(member_const.loginReturnUrlKey);
      if(return_url == "" || return_url == null || return_url == this.router.url){
        this.router.navigate(['/home']);
      }else{

        if(return_url.split("?").length >1){
          let queryStr = return_url.split("?")[1];
          let navigate_str = return_url.split("?")[0];
          let url_param = this.memberService.queryStringToJSON(queryStr);
          
          this.router.navigate([navigate_str],{
            queryParams: url_param
          });

          return;

        }
        this.router.navigate([return_url]);
      }
      
      
    },error=>{
      this.loading.login = 0;
      console.log(error)
    })


  }

  openAlert(paramStr: string) {
    let dialofRef = this.dialog.open(LoginFailComponent, {
      data: { message: paramStr }
    });

    dialofRef.afterClosed().subscribe((x) => {

    })

  }

  googleLogin(){
   this.memberService.googleLoginApi().then((user:any)=>{

    let loginData = {};

    const profile = user.getBasicProfile();
    // console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    // console.log('Name: ' + profile.getName());
    // console.log('Image URL: ' + profile.getImageUrl());
    // console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

    loginData['user_login_id'] = profile.getId();
    loginData['password'] = profile.getId();
    loginData['snsType'] = SNS.GOOGLE_CLIENT;
    loginData['email'] = profile.getEmail();

    const authInfo = user.getAuthResponse();
    // console.log("access token:" + authInfo.access_token);
    loginData['access_token'] = authInfo.access_token;

    this.login_common(1,loginData);

  }).catch((error:any)=>{
    console.log(error);
  });
  }

  snsLogin(loginData:any){


    
  }

}
