
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { member_const } from '../member/member_const/member_cosnt';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private cookieService:CookieService){}

    intercept(req:HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
        let headerSet:any = {};
        let token:any = localStorage.getItem(member_const.token_key);
        let csrf_token:any = this.cookieService.get("XSRF-TOKEN");

        if(csrf_token != ""){
            headerSet["X-XSRF-TOKEN"] = csrf_token;
        }

        if(token != null){
            headerSet["Authorization"] = "bearer " +  token;
        }


        
       // headerSet["Content-Type"] = "application/x-www-form-urlencoded";

        let newReq:HttpRequest<any> = req.clone({
            setHeaders:headerSet
        })

        return next.handle(newReq);
        

    }

}