
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { member_const } from '../member/member_const/member_cosnt';
import { tap, map, catchError } from 'rxjs/operators'
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(
        private cookieService: CookieService,
        private router:Router
        ) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let headerSet: any = {};
        let token: any = localStorage.getItem(member_const.token_key);
        let csrf_token: any = this.cookieService.get("XSRF-TOKEN");

        if (csrf_token != "") {
            headerSet["X-XSRF-TOKEN"] = csrf_token;
        }

        if (token != null) {
            headerSet["Authorization"] = "bearer " + token;
        }



        // headerSet["Content-Type"] = "application/x-www-form-urlencoded";

        let newReq: HttpRequest<any> = req.clone({
            setHeaders: headerSet
        })

        let eventRes = next.handle(newReq).pipe(map(x=>{
            // console.log(x);
            return x;
        }),catchError((err)=>{
            if(err.status == 401){
                if(err['error']['error'] == "invalid_token"){
                    //localStorage.removeItem(member_const.token_key);
                    this.setReturnUrl();
                    localStorage.removeItem(member_const.token_key);
                    localStorage.removeItem(member_const.token_expire_key);
                    this.router.navigate(["member/login"]);
                }
            }
            return throwError(err);
        }));

        return eventRes;


    }
    setReturnUrl() {

        if(this.router.url != "/member/login"){
            sessionStorage.setItem(member_const.loginReturnUrlKey,this.router.url);
        }
       
    }



}