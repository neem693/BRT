import { Component, OnInit, HostListener } from '@angular/core';
import { MemberServiceService } from 'src/app/member/member-service.service';
import { member_const } from 'src/app/member/member_const/member_cosnt';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-selector',
  templateUrl: './header-selector.component.html',
  styleUrls: ['./header-selector.component.css']
})
export class HeaderSelectorComponent implements OnInit {

  loginstate:boolean =false;

  constructor(
    private memberService:MemberServiceService,
    private router:Router
    ) { }


  evalSearch = {
    type1: 0,
    type2: 0,
    searchText:"",
    order: 0,
    order2: 0,
    order3:0,
    pageNum: 1,

  }

  ngOnInit() {

    this.memberService.loginState.subscribe((x)=>{
      this.loginstate = x;
    })

  }

  logout(){
    this.memberService.logout();
    location.reload();
    
  }

  goToSee(){

    
    window.location.href = "/eval/evalList?type1=1&type2=0&searchText=&order=0&order2=0&order3=0&pageNum=1";
    // this.evalSearch.type1 = 1;
    // this.router.navigate(['/eval/evalList'],{
    //   queryParams:this.evalSearch
    // })
    
  }

  goToListen(){

    window.location.href = "/eval/evalList?type1=2&type2=0&searchText=&order=0&order2=0&order3=0&pageNum=1";
    // this.evalSearch.type1 = 2;
    // this.router.navigate(['/eval/evalList'],{
    //   queryParams:this.evalSearch
    // })
    
  }

  goToDo(){

    window.location.href = "/eval/evalList?type1=3&type2=0&searchText=&order=0&order2=0&order3=0&pageNum=1";
    // this.evalSearch.type1 = 3;
    // this.router.navigate(['/eval/evalList'],{
    //   queryParams:this.evalSearch
    // })
    
  }

}
