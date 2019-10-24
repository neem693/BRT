import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, BehaviorSubject } from 'rxjs';
import { member_const } from './member_const/member_cosnt';

@Injectable({
  providedIn: 'root'
})

export class MemberServiceService {


  private loginStateSource = new BehaviorSubject(false);
  public loginState = this.loginStateSource.asObservable();

  constructor(private http:HttpClient) {}
  csrfGen():Observable<any>{
    return this.http.get(environment.baseApiUrl + "/member_public/csrfTokenGen");
  }

  JoinMember_common(param:any):Observable<any>{
   return this.http.post(environment.baseApiUrl + "/member_public/joinMember_common",param,{observe:'response'});
  }

  loginIdDuplicate(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrl + "/member_public/loginIdDuplicate",param);
  }

  emailDuplicate(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrl + "/member_public/emailDuplicate",param);
  }

  nicknameCheck(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrl + "/member_public/nicknameCheck",param);
  }

  login_common(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrlOrigin + "/oauth/token",param,{
      headers:{
       "Authorization" : member_const.basicToken ,
       "Content-Type" : "application/x-www-form-urlencoded"
      }
    });
  }

  changeLoginState(param:boolean){
    this.loginStateSource.next(param);
  }

  logout() {
    localStorage.removeItem(member_const.token_key);
    localStorage.removeItem(member_const.token_expire_key);
  }

 

}
