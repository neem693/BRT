import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { member_const } from './member/member_const/member_cosnt';
import { MemberServiceService } from './member/member-service.service';
import * as moment from "moment";

declare const $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TctPro';
  routeInfo:any;
  
  navManage={
    standardHeight:0,
    direction:0,
    limit:100,
  }

  constructor(router: Router, memberService: MemberServiceService) {
    router.events.subscribe((x) => {
      this.routeInfo = x;
      setTimeout(() => {
        if ($('.hr_01').hasClass('active') == false) {
          $('.hr_01').addClass('active');
          // console.log(11);
        }
        if ($('.subject').hasClass('active') == false) {
          $('.subject').addClass('active');
          // console.log(11);
        }
      }, 500)

      let token = localStorage.getItem(member_const.token_key);
      if (token != null && token != undefined) {

        let currentUnix = moment().unix();
        let expire_unix = Number(localStorage.getItem(member_const.token_expire_key));
        if (currentUnix > expire_unix) {
          memberService.logout();
          memberService.changeLoginState(false);
          return;
        }

        memberService.changeLoginState(true);
      } else {
        memberService.changeLoginState(false);
      }

    })

  }

  @HostListener('window:scroll', ['$event']) // for window scroll events
  onScroll(event:any) {
    const limit:number = this.navManage.limit;
    // const height = 100;
    

    let top:number = $(window).scrollTop();

    this.manageDirection(top);

    if(top >limit){
      $("#menu_nav").addClass('active');
    }else if(top <=limit){
      $("#menu_nav").removeClass('active');
    }
    // console.log(this.routeInfo);
  }
  manageDirection(top: number) {
    
    //direct 1 is down screen/ increse sroll top value
    //direct 0 is up screen/ decrease sroll top value
    if(this.navManage.direction == 0){
      if(this.navManage.standardHeight < top){
        this.navManage.direction = 1;
        $("#menu_nav").addClass("hidden");
      }
    }else if(this.navManage.direction == 1){
      if(this.navManage.standardHeight > top){
        this.navManage.direction = 0;
        $("#menu_nav").removeClass("hidden");
      }
    }
    
    this.navManage.standardHeight = top;

  }

}
