import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }


  // getTheProductList():Observable<any>{
  //   return this.http.get<any>(environment.ApiUrl + '/test/get');
  // }

  login(loginData:any){
    return this.http.post(environment.ApiUrl + "/login",loginData);
  }

  logout(){
    return this.http.post(environment.ApiUrl + "/logout","");
  }

}
