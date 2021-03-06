import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, BehaviorSubject } from 'rxjs';
import { member_const } from './member_const/member_cosnt';
import { Router } from '@angular/router';
import { GlobalServiceService } from '../global/global-service.service';


declare let gapi: any;
declare let Kakao: any;

@Injectable({
  providedIn: 'root'
})

export class MemberServiceService {




  private loginStateSource = new BehaviorSubject(false);
  public loginState = this.loginStateSource.asObservable();

  constructor(
    private http: HttpClient,
    private router:Router,
    private globalService:GlobalServiceService) { }
  csrfGen(): Observable<any> {
    return this.http.get(environment.baseApiUrl + "/member_public/csrfTokenGen");
  }

  JoinMember_common(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrl + "/member_public/joinMember_common", param, { observe: 'response' });
  }

  JoinSnsMember_common(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrl + "/member_public/joinMember_sns", param, { observe: 'response' });
  }

  loginIdDuplicate(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrl + "/member_public/loginIdDuplicate", param);
  }

  emailDuplicate(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrl + "/member_public/emailDuplicate", param);
  }

  nicknameCheck(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrl + "/member_public/nicknameCheck", param);
  }

  login_common(param: any): Observable<any> {
    return this.http.post(environment.baseApiUrlOrigin + "/oauth/token", param, {
      headers: {
        "Authorization": member_const.basicToken,
        "Content-Type": "application/x-www-form-urlencoded"
      }
    });
  }

  changeLoginState(param: boolean) {
    this.loginStateSource.next(param);
  }



  logout() {
    localStorage.removeItem(member_const.token_key);
    localStorage.removeItem(member_const.token_expire_key);
  }

  queryStringToJSON(qs: string) {
    qs = qs || location.search.slice(1);

    var pairs = qs.split('&');
    var result = {};
    pairs.forEach(function (p) {
      var pair = p.split('=');
      var key = pair[0];
      var value = decodeURIComponent(pair[1] || '');

      if (result[key]) {
        if (Object.prototype.toString.call(result[key]) === '[object Array]') {
          result[key].push(value);
        } else {
          result[key] = [result[key], value];
        }
      } else {
        result[key] = value;
      }
    });

    return JSON.parse(JSON.stringify(result));
  };

  fireBaseInit(): any {

    // // Your web app's Firebase configuration
    // var firebaseConfig = {
    //   apiKey: "AIzaSyAlLzBue8oVny9t7KY2JU2cqlKdWAP9Z7M",
    //   authDomain: "thecomment-cb68d.firebaseapp.com",
    //   databaseURL: "https://thecomment-cb68d.firebaseio.com",
    //   projectId: "thecomment",
    //   storageBucket: "thecomment.appspot.com",
    //   messagingSenderId: "21771763229",
    //   appId: "1:21771763229:web:f16934a6ceb709ba6e50f4"
    // };
    // // Initialize Firebase
    // firebase.initializeApp(firebaseConfig);


    // let provider = new firebase.auth.GoogleAuthProvider();
    // provider.addScope('https://www.googleapis.com/auth/firebase.readonly');

    // return new Promise((resolve, reject) => {
    //   firebase.auth().signInWithPopup(provider).then(function (result) {
    //     // This gives you a Google Access Token. You can use it to access the Google API.
    //     var token = result.credential.accessToken;
    //     // The signed-in user info.
    //     var user = result.user;
    //     // ...
    //     alert(result);
    //     resolve(result);
    //   }).catch(function (error) {
    //     // Handle Errors here.
    //     var errorCode = error.code;
    //     var errorMessage = error.message;
    //     // The email of the user's account used.
    //     var email = error.email;
    //     // The firebase.auth.AuthCredential type that was used.
    //     var credential = error.credential;
    //     // ...
    //     alert(error);
    //     reject(error);
    //   });

    //   // resolve(provider);
    // })


  }


  googleLoginApi() {
    return new Promise((resolve, reject) => {


      gapi.load('auth2', function () {
        gapi.auth2.init({
          client_id: '21771763229-ha6vtbu74oa43jbj40gjj40kngqinodp.apps.googleusercontent.com'
        }).signIn({
          scope: 'profile email'
        }).then((user: any) => {
          resolve(user);
        }).catch((error: any) => {
          reject(error);
        })
        // gapi.auth2.init();
        /* Ready. Make a call to gapi.auth2.init or some other API */
      });

    })
  }

  kakaoLoginApi() {

    let data = {
      auth: {},
      data: {}
    }

    return new Promise((resolve, reject) => {
      if (Kakao.isInitialized() == false) {
        Kakao.init('b83ba4e754129ff630a7ffe5f0aefbe8');
      }
      Kakao.Auth.login({
        success: function (authObj) {
          data.auth = authObj;
          Kakao.API.request({
            url: '/v2/user/me',
            success: function (res) {
            
              if(res['kakao_account'] == undefined || 
              res['kakao_account']['email'] == undefined){
                Kakao.API.request({
                  url: '/v1/user/unlink',
                });
                
                reject("4023");
              }
              data.data = res;
              resolve(data); 
            },
            fail: function (error) {
              reject(error);
            },
          });
        },
        fail: function (err) {
          reject(err);
        }
      });
    })

  }

  /**
   * 로그인이 안되어 있으면 현재 페이지를 저장하고 로그인페이지로 라우팅 시킴.
   * 리턴 값으로는 로그인이 되어 있으면 true 리턴, 아니면 false 리턴
   */
  public loginRequired(){
    let loginStateValue:boolean;
    this.loginState.subscribe(x=>{
      loginStateValue = x;
    })

   
    if(loginStateValue == false){
      this.globalService.openGlobalAlert("로그인이 필요합니다.");
      if(this.router.url != "/member/login"){
        sessionStorage.setItem(member_const.loginReturnUrlKey,this.router.url);
      }
      localStorage.removeItem(member_const.token_key);
      localStorage.removeItem(member_const.token_expire_key);
      this.router.navigate(["member/login"]);
      return false;
    }
    return true;
  }



  emailVerify(data: any) {
    return this.http.post(environment.baseApiUrl + "/member_public/emailVerify",data);
  }

  sendEamilAgain(data: any) {
    return this.http.post(environment.baseApiUrl + "/member_public/sendEmailAgain",data);
  }

}
