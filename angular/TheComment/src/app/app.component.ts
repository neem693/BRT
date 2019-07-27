import { Component } from '@angular/core';

import * as moment from 'moment';
import { MyServiceService } from './my-service.service';
import {AlbumFetchService} from './album-fetch.service'
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { CommonData } from './common/common-data';
import {environment} from '../environments/environment'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations:[
    trigger('myanimation',[
      state('smaller',style({
        transform : 'translateY(100px)'
      })),
      state('larger',style({
        transform : 'translateY(0px)'
      })),
      transition('smaller <=> larger',animate('300ms ease-in'))
    ])
  ]
})
export class AppComponent {
  dateStr: string = moment().format("YYYY년 MM월 DD일");
  datedate: Date = new Date();
  jsonVal = { name: 'ROx', age: 25 };

  title = 'The Comment';

  month_value: string = "October";

  months = ["January", "February", "March", "April", "May", "June", "July",
    "August", "September", "October", "November", "December"];

  myservie_title:string;
  todaydate: Date;
  componetproperty: any;

  formdata: any;

  public persondata = [];
  userData = {};
  albumData: any;

  //에니메이션 용도
  state:string = "smaller";

  selectForm:any;

  condition1:string;
  condition2:string;

  userlist = [];

  

  myClickFunction(event: any) {
    alert("Button is clicked");
    console.log(event);
    this.isvaildate = !this.isvaildate;
  }

  isvaildate = true;

  changemonths(event: any) {

    alert("event is occure");
    console.log(event);
  }

  constructor(private albumService:AlbumFetchService,private myservice: MyServiceService,private commonData:CommonData) { }

  ngOnInit() {
    // this.selectForm = new FormGroup({
    //   month_value: new FormControl("October")
    // })
    this.myservice.title.subscribe(x=> this.title = x);
    this.myservice.changeTitle('The Comment');

    this.todaydate = this.myservice.showTodayDate();
    console.log(this.myservice.serviceproperty);
    this.myservice.serviceproperty = "component created";
    this.componetproperty = this.myservice.serviceproperty;
    this.myservice.getdata().subscribe(
      (data) => {
        this.persondata = Array.from(Object.keys(data), k => data[k]);
        console.log(this.persondata);
      }
    );

    this.formdata = new FormGroup({
      emailid: new FormControl("",Validators.compose([
        Validators.required,
        Validators.pattern( /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)
      ])),
      passwd: new FormControl("",this.pwdValidator)
    });

    this.albumService.getAlbumData().subscribe(data=>{
      this.albumData = data;
      console.log(this.albumData)
    });
  }

  pwdValidator(formControl:FormControl){
    console.log(formControl.value);
    if(formControl.value.length <5){
      return {'passwd':true};
    }
  }

  onClickSubmit(data: any) {

    // if (!regexp.test(data.emailid)) {
    //   alert("이메일 형식에 맞지 않습니다.");
    //   return;
    // };
    alert("입력하신 데이터는 다음과 같습니다." + data.stringify);
  }


  onDrop(event:any){
    console.log(event);
    if(event.previousContainer === event.container){
      moveItemInArray(event.container.data,event.previousIndex,event.currentIndex);
    }else{
      transferArrayItem(event.previousContainer.data,event.container.data,event.previousIndex,event.currentIndex);
    }
  }

  animation(){
    this.state = this.state == 'larger' ? 'smaller' : 'larger';
  }


}
