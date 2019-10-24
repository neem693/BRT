import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { LoginFailComponent } from '../dialog/login-fail/login-fail.component';
import { MemberServiceService } from '../member-service.service';
import { CookieService } from 'ngx-cookie-service';
import * as moment from 'moment';
import { member_const } from '../member_const/member_cosnt';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import 'url-search-params-polyfill';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData: any;

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

  login_common() {

    let key: string;
    let data: any = this.loginData;
    let param: URLSearchParams = new URLSearchParams();
    for (key in data) {

      if (data[key]['errors'] != null) {

        this.openAlert("아이디와 패스워드를 입력해주세요.");
        return;

      }

      param.append(key, data[key]['value']);

    }

    param.append("grant_type", 'password');

    this.memberService.login_common(param.toString()).subscribe((x) => {

      let expire_sec = x["expires_in"];
      expire_sec += moment().unix();
      expire_sec -= 500;
      localStorage.setItem(member_const.token_key, x["access_token"]);
      localStorage.setItem(member_const.token_expire_key, expire_sec);

      this.router.navigate(['/home']);

    })


  }

  openAlert(paramStr: string) {
    let dialofRef = this.dialog.open(LoginFailComponent, {
      data: { message: paramStr }
    });

    dialofRef.afterClosed().subscribe((x) => {

    })

  }

}
