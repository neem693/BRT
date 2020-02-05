import { Component, OnInit, AfterViewInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { MemberServiceService } from '../member-service.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { JoinFailComponent } from '../dialog/join-fail/join-fail.component';
import { Store, select } from '@ngrx/store';
import { AppState } from 'src/app/ngrx/state/state';
import { GlobalDialogComponent } from 'src/app/global/dialog/global-dialog/global-dialog.component';
import { RESULT } from 'src/const/publicConst';
import { GlobalServiceService } from 'src/app/global/global-service.service';

@Component({
  selector: 'app-sns-join',
  templateUrl: './sns-join.component.html',
  styleUrls: ['./sns-join.component.css']
})
export class SnsJoinComponent implements OnInit,AfterViewInit {


  loginData = {
    user_login_id: new FormControl("", {
      validators: Validators.compose([
        Validators.required,
        // Validators.pattern(/^[a-zA-z0-9]{5,20}$/),
      ])
    }),
    nickname: new FormControl("", Validators.compose([
      Validators.required,
      Validators.pattern(/^.[가-힣a-zA-Z0-9]{3,20}$/)
    ])),
    email: new FormControl("", Validators.compose([
      Validators.required,
      Validators.pattern(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)
    ])),
    sns_type: new FormControl("", {
      validators: Validators.compose([
        Validators.required,
        // Validators.pattern(/^[a-zA-z0-9]{5,20}$/),
      ])
    }),
    access_token: new FormControl("", {
      validators: Validators.compose([
        Validators.required,
        // Validators.pattern(/^[a-zA-z0-9]{5,20}$/),
      ])
    }),
  }

  password_confirm = new FormControl("", Validators.compose([
    Validators.required,
    Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)
  ]))

  duplicate: any = {
    user_login_id: false,
    email: false
  }

  user_login_id_dup = 0;

  snsData = {
    access_token:""
  };


  constructor(public dialog: MatDialog,
    private memberService: MemberServiceService,
    private cookieService: CookieService,
    private router: Router,
    private store:Store<AppState>,
    private globalService:GlobalServiceService) { }

  ngOnInit() {

    this.store.select("userInfo").subscribe(x=>{
      if(x == undefined){
        return;
      }
      this.snsData = Object.assign({},x['payload']);
      //액세스 토큰이 없다면 login  페이지로 리턴
    })

    if(this.snsData['access_token'] == undefined || this.snsData['access_token'] == ""){
      this.globalService.openGlobalAlert('잘못된 접근입니다.')
      this.router.navigate(["/member/login"])
      return;
    }  
    this.memberService.csrfGen().subscribe(
      (result) => {
        this.cookieService.set("XSRF-TOKEN", result['token'], 0, "/member");
      }
    );


    //map test
    // let map_data = of(1,2,3).pipe(map(x=>{
    //   let str:string = 'ee' + x;
    //   return {[str]:x};
    // }
    //   ));
    // map_data.subscribe((x)=>console.log(x));

  }

  ngAfterViewInit(): void {
    this.loginData.user_login_id.setValue(this.snsData['user_login_id']);
    this.loginData.email.setValue(this.snsData['email']);
    this.loginData.sns_type.setValue(this.snsData['snsType']);
    this.loginData.access_token.setValue(this.snsData['access_token']);
    // console.log(this.loginData.user_login_id.value);

  }


  saveMember(data: any): void {

    let key: any;
    let memberInfo = {};

    console.log(data);
    for (key in data) {
      //key에 errors값이 null이 아니면 문제가 있다는 것
      if (data[key]['errors'] != null) {
        let userId = {};
        // userId['reason'] = key;
        this.openAlert(userId);
        return;
      }
      memberInfo[key] = data[key]['value'];
    }
    this.memberService.JoinSnsMember_common(memberInfo).subscribe(
      (result) => {

        if (result.status == 200) {
          this.router.navigate(['/member/join_success', memberInfo['user_login_id']])
        }

      }, (error) => {
        let errorData = error.error;
        let message:string = errorData[RESULT.ERROR_MESSAGE];
        let code = message.split(":")[0];
        if(code == "4021" || code == "4023"){
          this.globalService.openGlobalAlert("잘못된 접근입니다.");
          this.router.navigate(["/member/login"]);
        }else if(code == "4031"){
          this.globalService.openGlobalAlert("이메일이 이미 등록되어 있기에 가입할 수 없습니다.");
          this.router.navigate(["/member/login"]);
        }

      }
    )
  }

  loginIdDuplicate(userId: FormControl) {

    if (this.loginData.user_login_id.hasError("pattern")) {
      return;
    }

    this.memberService.loginIdDuplicate({ "user_login_id": userId.value })
      .subscribe((x) => {
        if (x["dup"] == 1) {

          let error = userId.errors;
          if (error == null) {
            error = { 'customVali': true };
          } else {
            error['customVali'] = true;
          }

          userId.setErrors(error);

        } else {
          if (userId.errors == null) {
            return;
          }
          delete userId.errors['customVali'];
        }
      })
  }


  openAlert(userId: any): void {
    let dialogRef = this.dialog.open(JoinFailComponent, {
      data: userId,
      width: '500px'
    })

    dialogRef.afterClosed().subscribe((x) => {
      console.log(x);
      console.log('the dialog was closed');
    })

  }

  nicknameDuplicate(emailForm:FormControl){

    if(emailForm.hasError('pattern')){
      return;
    }

    let error = emailForm.errors;
    let errorIsEmpty:boolean = false;
    if(error == null){
      errorIsEmpty = true;
      error = {};
    }

    this.memberService.nicknameCheck({'nickname':emailForm.value}).subscribe(
      (x)=>{
        const count = x['dup'];
        if(count != 0){
          error['nicknameDup'] = true;
          emailForm.setErrors(error);
        }else{
          if(errorIsEmpty){
            return;
          }
          delete emailForm.errors['nicknameDup'];
        }
      }
    )
  }

  emailDuplicate(emailForm:FormControl){

    if(emailForm.hasError('pattern')){
      return;
    }

    let error = emailForm.errors;
    let errorIsEmpty:boolean = false;
    if(error == null){
      errorIsEmpty = true;
      error = {};
    }

    this.memberService.emailDuplicate({'email':emailForm.value}).subscribe(
      (x)=>{
        const count = x['dup'];
        if(count != 0){
          error['emailDup'] = true;
          emailForm.setErrors(error);
        }else{
          if(errorIsEmpty){
            return;
          }
          delete emailForm.errors['emailDup'];
        }
      }
    )
  }

}
