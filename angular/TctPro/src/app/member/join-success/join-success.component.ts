import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemberServiceService } from '../member-service.service';
import { RESULT } from 'src/const/publicConst';

@Component({
  selector: 'app-join-success',
  templateUrl: './join-success.component.html',
  styleUrls: ['./join-success.component.css']
})
export class JoinSuccessComponent implements OnInit {
  loading:number = 0;
  sendAgain:number = 1;
  check:number =1;
  user_login_id:string;
  key:string;

  constructor(
    private route:ActivatedRoute,
    private memberService:MemberServiceService,
    ) { }

  ngOnInit() {

    window.scrollTo(0,0);

    this.route.paramMap.subscribe((x)=>{
      console.log(x);
      this.user_login_id = x['params']["id"];
      this.route.queryParams.subscribe((x)=>{
        if(x['key'] != undefined && x['key'] != "" ){
          this.key  = x['key'];
          this.emailVerify();
        }
      })
    })

  
    
  }

  emailVerify(){
    let data = {};
    data['user_login_id'] = this.user_login_id;
    data['key'] = this.key;

    this.loading = 1;
    this.memberService.emailVerify(data).subscribe(x=>{
      let result = x[RESULT.RESULT_KEY];
      if(result == 200){
        this.check = 2;
      }else{
        this.check = 3;
      }
      this.loading = 0;
    },error =>{
      this.loading = 0;
    });
  }

  sendEmailAgain(){
    let data = {};
    data['user_login_id'] = this.user_login_id;
    this.sendAgain = 0;
    this.loading = 1;
    this.memberService.sendEamilAgain(data).subscribe(x=>{
      this.loading = 0;
      let result = x[RESULT.RESULT_KEY];
    },error=>{
      this.loading = 0;
    });

  }

}
