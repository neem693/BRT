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
import { SNS, RESULT } from 'src/const/publicConst';
import { Store } from '@ngrx/store';
import { UserInfo, SnsBasicUserInfo } from 'src/app/vo/user';
import { userinfoTempSave } from 'src/app/ngrx/action/action';
import { AppState } from 'src/app/ngrx/state/state';
import { GlobalDialogComponent } from 'src/app/global/dialog/global-dialog/global-dialog.component';
import { GlobalServiceService } from 'src/app/global/global-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: any;
  /** spin circle loading bar */
  loading = {
    login: 0
  }

  reset_userinfo: UserInfo = {
    user_id: 0,
    nickname: "",
    user_login_id: "",
    password: "",
    email: "",
    access_token: "",
    sns_user_unique_id: "",
    snsType: "",
    sns_email: "",
  };


  firebaseVar: any;

  constructor(private dialog: MatDialog,
    private memberService: MemberServiceService,
    private cookieService: CookieService,
    private router: Router,
    private store: Store<AppState>,
    private globalService:GlobalServiceService) { }

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
   * snslogin : 1 sns 로그인 모드, 0 일반모드
   * additionalData : sns 데이터시에 필요한 데이터
   */
  login_common(snslogin: any, additionalData: any) {
    console.log("login");
    let key: string;
    let data: any;
    if (snslogin == 1) {
      data = additionalData;
    } else {
      data = this.loginData;
    }

    let param: URLSearchParams = new URLSearchParams();
    for (key in data) {

      if (data[key]['errors'] != null) {

        this.openAlert("아이디와 패스워드를 입력해주세요.");
        return;

      }
      if (snslogin == 1) {
        param.append(key, data[key]);
      } else {
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
      if (return_url == "" || return_url == null || return_url == this.router.url) {
        this.router.navigate(['/home']);
      } else {

        if (return_url.split("?").length > 1) {
          let queryStr = return_url.split("?")[1];
          let navigate_str = return_url.split("?")[0];
          let url_param = this.memberService.queryStringToJSON(queryStr);

          this.router.navigate([navigate_str], {
            queryParams: url_param
          });

          return;

        }
        this.router.navigate([return_url]);
      }


    }, error => {
      this.loading.login = 0;
      let message: string = error['error'][RESULT.ERROR_MESSAGE];
      let code = message.split(":")[0];

      if(code == "4013"){
        this.router.navigate(["/member/join_success",this.loginData.user_login_id.value]);
      }

      if (code == "4022") {
        if (confirm("등록되지 않은 SNS 유저입니다. 가입하시겠습니까?") == true) {

          this.reset_userinfo.user_login_id = additionalData['user_login_id'];
          this.reset_userinfo.snsType = additionalData['snsType'];
          this.reset_userinfo.access_token = additionalData['access_token'];
          this.reset_userinfo.email = additionalData['email'];

          this.store.dispatch(userinfoTempSave({ payload: this.reset_userinfo }));
          this.router.navigate(["/member/sns_join"]);

        }
      }
    })


  }

  openAlert(paramStr: string) {
    let dialofRef = this.dialog.open(LoginFailComponent, {
      data: { message: paramStr }
    });

    dialofRef.afterClosed().subscribe((x) => {

    })

  }

  googleLogin() {
    this.memberService.googleLoginApi().then((user: any) => {

      let loginData:SnsBasicUserInfo = {
        access_token: "",
        email:"",
        password:"",
        snsType:"",
        user_login_id:"",
      };;

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

      this.login_common(1, loginData);

    }).catch((error: any) => {
      
      console.log(error);
    });
  }

  kakaoLogin() {
    this.memberService.kakaoLoginApi().then((data)=>{
      let loginData:SnsBasicUserInfo ={
        access_token: "",
        email:"",
        password:"",
        snsType:"",
        user_login_id:"",
      };

      let userData = data['data'];
      let authData = data['auth'];

      loginData.user_login_id = userData['id'];
      loginData.password = userData['id'];
      loginData.access_token = authData['access_token'];
      loginData.snsType = SNS.KAKAO_CLIENT;
      loginData.email = userData['kakao_account']['email'];

      this.login_common(1,loginData);

    }).catch(error=>{

      if(typeof error == "string"){
        if(error == "4023"){
          this.globalService.openGlobalAlert("이메일을 선택해주세요.");
        }
      }


    });
  }
}
