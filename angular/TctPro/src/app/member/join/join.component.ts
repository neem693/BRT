import { Component, OnInit, Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn, AsyncValidator, ValidationErrors } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { JoinFailComponent } from '../dialog/join-fail/join-fail.component';
import { MemberServiceService } from '../member-service.service';
import { CookieService } from 'ngx-cookie-service';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-join',
  templateUrl: './join.component.html',
  styleUrls: ['./join.component.css']
})
export class JoinComponent implements OnInit {

  loginData = {
    user_login_id: new FormControl("", {
      validators: Validators.compose([
        Validators.required,
        Validators.pattern(/^[a-zA-z0-9]{5,20}$/),
      ])
    }),
    password: new FormControl("", Validators.compose([
      Validators.required,
      Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)
    ])),
    nickname: new FormControl("", Validators.compose([
      Validators.required,
      Validators.pattern(/^.[가-힣a-zA-Z0-9]{3,20}$/)
    ])),

    email: new FormControl("", Validators.compose([
      Validators.required,
      Validators.pattern(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)
    ])),

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

  loading = {
    join:0,
  }


  constructor(public dialog: MatDialog,
    private memberService: MemberServiceService,
    private cookieService: CookieService,
    private customVali: customVali,
    private router: Router) { }

  ngOnInit() {

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


  saveMember(data: any): void {

    let key: any;
    let memberInfo = {};

    // console.log(data);
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
    this.loading.join = 1;
    this.memberService.JoinMember_common(memberInfo).subscribe(
      (result) => {
        this.loading.join = 0;
        if (result.status == 200) {
          this.router.navigate(['/member/join_success', memberInfo['user_login_id']])
        }

      }, (error) => {
        this.loading.join = 0;
        // console.log(error);
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

  password_confirm_change(formControl:FormControl):void{
    let password = this.loginData.password.value;
    let error = formControl.errors;
    if(error == null){
      error = {};
    }

    if(password == formControl.value){
      
      if(formControl.errors == null){
        return;
      }

      delete formControl.errors['password_reconfirm'];
    }else{
      error['password_reconfirm'] = true;
      formControl.setErrors(error);
    }
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




@Injectable({
  providedIn: 'root'
})
export class customVali implements AsyncValidator {

  constructor(private memberService: MemberServiceService) {

  }

  validate(control: AbstractControl): Promise<ValidationErrors> | Observable<ValidationErrors> {
    return this.memberService.loginIdDuplicate({ "user_login_id": control.value }).pipe(
      map(x => {
        if (x["dup"] == 1) {
          return { 'customVali': true }
        } else {
          return null;
        }
      }));
  }


}
