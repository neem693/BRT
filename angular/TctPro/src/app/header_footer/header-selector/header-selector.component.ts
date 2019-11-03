import { Component, OnInit, HostListener } from '@angular/core';
import { MemberServiceService } from 'src/app/member/member-service.service';
import { member_const } from 'src/app/member/member_const/member_cosnt';

@Component({
  selector: 'app-header-selector',
  templateUrl: './header-selector.component.html',
  styleUrls: ['./header-selector.component.css']
})
export class HeaderSelectorComponent implements OnInit {

  loginstate:boolean =false;

  constructor(private memberService:MemberServiceService) { }

  ngOnInit() {

    this.memberService.loginState.subscribe((x)=>{
      this.loginstate = x;
    })

  }

  logout(){
    this.memberService.logout();
    location.reload();
    
  }
}
