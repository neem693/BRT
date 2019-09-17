import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { analyzeAndValidateNgModules } from '@angular/compiler';

declare const Cookies:any;

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    intercept(req:HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let headerSet:any = {};
        if(Cookies.get("XSRF-TOKEN") != undefined){
            headerSet["X-XSRF-TOKEN"] = Cookies.get("XSRF-TOKEN");
        }


        let clonedreq:HttpRequest<any> = req.clone({
            setHeaders:headerSet
        });
        console.log(Cookies.get("XSRF-TOKEN"));
        return next.handle(clonedreq);
        

        
    }





}