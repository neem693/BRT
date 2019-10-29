import { Component } from '@angular/core';
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

  constructor(router: Router, memberService: MemberServiceService) {
    router.events.subscribe((x) => {
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


}
