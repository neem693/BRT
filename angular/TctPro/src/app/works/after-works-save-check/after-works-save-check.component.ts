import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute } from '@angular/router';
import { WorksSerivceService } from '../works-serivce.service';
import { RESULT } from 'src/const/publicConst';

@Component({
  selector: 'app-after-works-save-check',
  templateUrl: './after-works-save-check.component.html',
  styleUrls: ['./after-works-save-check.component.css']
})
export class AfterWorksSaveCheckComponent implements OnInit {

  workId:number;
  add={
    worksAdd:false,
    artistAdd:false,
    evaluateAdd:false
  }

  data = {
    work:{},
    artist:{},
  }

  constructor(private route:ActivatedRoute,private worksService:WorksSerivceService) { }

  ngOnInit() {
   this.route.params.subscribe(x=>{
      this.workId = Number(x['id']);
      console.log(this.workId);
      this.selectWorksOne();
   })
 
  }

  selectWorksOne(){
    let data = {};
    data['id'] = this.workId;
    this.worksService.worksSelectOne(data).subscribe(x=>{
      if(x[RESULT.RESULT_KEY] == 201){
        //all not add
      }else if(x[RESULT.RESULT_KEY] == 202){
        this.add.worksAdd= true;
        this.data.work = x[RESULT.DATA_KEY];
      }else if(x[RESULT.RESULT_KEY] == 200){
        this.add.worksAdd = true;
        this.add.evaluateAdd = true;
        this.add.artistAdd =true;
        this.data.work = x[RESULT.DATA_KEY];
      }
    })
  }

}
