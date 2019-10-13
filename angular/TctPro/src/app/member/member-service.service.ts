import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class MemberServiceService {

  constructor(private http:HttpClient) {}
  csrfGen():Observable<any>{
    return this.http.get(environment.baseApiUrl + "/member_public/csrfTokenGen");
  }

  JoinMember_common(param:any):Observable<any>{
   return this.http.post(environment.baseApiUrl + "/member_public/joinMember_common",param);
  }

  loginIdDuplicate(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrl + "/member_public/loginIdDuplicate",param);
  }

  emailDuplicate(param:any):Observable<any>{
    return this.http.post(environment.baseApiUrl + "/member_public/emailDuplicate",param);
  }

 

}
