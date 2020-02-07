import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { RESULT } from 'src/const/publicConst';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  seeEval:any[] = [];
  listenEval:any[] = [];
  doEval:any[] = [];

  home_loading:number = 1;
  constructor(
    private homeService:HomeService,
    private router:Router
    ) { }

  ngOnInit() {

    console.log(this.seeEval);

    this.homeService.getHomeEvalItem().subscribe(x=>{
      let result = x[RESULT.RESULT_KEY];
      let data = x[RESULT.DATA_KEY];
      this.seeEval = data['see'];
      this.listenEval = data["listen"];
      this.doEval = data["do"];

      this.home_loading = 0;
      
    },error=>{
      this.home_loading = 0;
    });

  }

    /**
   * go to Detail of evalItem detail
   */
  goToDetail(item:any){
    this.router.navigate(["/eval/evalDetail",item.eval_item_id]);
  }

}
