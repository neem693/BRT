import { Component, OnInit, ViewChild } from '@angular/core';
import { SwiperConfigInterface, SwiperComponent } from 'ngx-swiper-wrapper';
import { FormControl, Validators } from '@angular/forms';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { ActivatedRoute, Router } from '@angular/router';
import { EvalService } from '../eval.service';
import { RESULT } from 'src/const/publicConst';

declare const $:any;

@Component({
  selector: 'app-eval-serach',
  templateUrl: './eval-serach.component.html',
  styleUrls: ['./eval-serach.component.css']
})
export class EvalSerachComponent implements OnInit {

  public config: SwiperConfigInterface = {
    slideToClickedSlide: true,
    loop: true,
    direction: 'horizontal',
    slidesPerView: 5,
    mousewheel: true,
    centeredSlides: true,
    pagination: { clickable: true, el: '.swiper-pagination' },
  };

  typeList = {
    data: [],
    type2: [],
    type1Index: 0,
    type2Index: 0,
  }

  loading = {
    type: 0,
    search: 0,
    firstLoading: 0,
  }

  search = {
    type1: 0,
    type2: 0,
    searchText: new FormControl("", [
      Validators.maxLength(60)
    ]),
    order: 0,
    order2: 0,
    order3:0,
    pageNum: 1,

  }


  show ={
    wordSearchStr: "코멘트",
    wordSearchDialogue:"Search the Evaluation Comment Words",
  }

  evalData = {
    list : [],
    
  }

  page = {
    evalData: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10,
    },
  }

  private swiperType1: SwiperComponent;
  private swiperType2: SwiperComponent;

  @ViewChild('type1', { static: false }) set swiperType1_viewchild(content: SwiperComponent) {
    this.swiperType1 = content;
  }
  @ViewChild('type2', { static: false }) set swiperType2_viewchild(content: SwiperComponent) {
    this.swiperType2 = content;
  }

  constructor(
    private workService:WorksSerivceService,
    private route:ActivatedRoute, 
    private router:Router,
    private evalService:EvalService
    ) { }

  ngOnInit() {
    
    this.getAllType();

    this.route.queryParams.subscribe(x=>{
      if(this.loading.firstLoading == 0){
        for(let key in x){

          if(key == "searchText"){
            this.search.searchText.setValue(x[key]);
            continue;
          }
    
          this.search[key] = Number(x[key]);
    
        }
        if(this.search.order3 == 0){
      
          this.show.wordSearchStr = "코멘트"
          this.show.wordSearchDialogue = "Search the Evaluation Comment Words";
    
        }else if(this.search.order3 == 1){
    
          this.show.wordSearchStr = "소재";
          this.show.wordSearchDialogue = "Search the Evaluation SubjectMatter Words"
    
        }
      }

      if(this.router.url.indexOf("?") == -1){
        this.evalSearchNativeUrl(1);
        
        
      }else{
        this.evalSearch(x);
      }
    })
  }


  /*************모든 타입 불러오기********** */
  getAllType() {

    this.workService.getAllWorkType().subscribe((result) => {
      this.typeList.data = Object.assign([], result);

      for (var i = 0; i < this.typeList.data.length; i++) {

        this.typeList.data[i].type2Dto.unshift({ type2_name: "전체", type2_id: 0 });

        // for(var j =0; j<this.typeList.data[i].type2Dto.length; j++){

        // }

      }

      this.typeList.data.unshift({ type1_name: "전체", type1_id: 0 });
      this.loading.type = 1;

      setTimeout(() => {
        for (var i = 1; i < this.typeList.data.length; i++) {
          // console.log(this.typeList.data[i].type1_id);
          // console.log(this.search.type1);
          if (this.typeList.data[i].type1_id == this.search.type1) {
            this.typeList.type1Index = i;
            this.swiperType1.directiveRef.setIndex(i);
            console.log("type1 index" + this.typeList.type1Index);
            setTimeout(() => {
              for (var j = 1; j < this.typeList.data[this.typeList.type1Index].type2Dto.length; j++) {
                console.log(this.search.type2);
                if (this.typeList.data[this.typeList.type1Index].type2Dto[j].type2_id == this.search.type2) {
                  this.typeList.type2Index = j;
                  this.swiperType2.directiveRef.setIndex(j);
                  console.log(j + " type2 " + this.typeList.type2Index);
                }
              }
            }, 100)

          }
        }

        this.loading.firstLoading = 1;

      }, 100);


      console.log(this.typeList);
    });

  }

  /**type1 change event */
  type1Change(index: number) {
    this.search.type1 = this.typeList.data[index].type1_id;
    if (this.loading.firstLoading == 1) {
      this.search.type2 = 0;
    }

    this.typeList.type1Index = index;
    this.typeList.type2Index = 0;

    console.log(this.search.type1 + "type1");
    this.searchChange(index);
  }

  /**type1 change event */
  type2Change(index: number) {
    this.typeList.type2Index = index;
    this.search.type2 = this.typeList.data[this.typeList.type1Index].type2Dto[index].type2_id;

    // this.search.type1 = this.typeList.data[index].type1_id;
    // console.log(this.search.type1);
    console.log(this.search.type2 + "type2");
    this.searchChange(index);
  }

  /**
   * searchChange function
   * searchParam change trigger this function
   * @param event 
   */
  searchChange(event: any) {
    // console.log(event);
  }

  evalSearchNativeUrl(page:number){

    let param = {};
    this.search.pageNum  = page;

    for(let key in this.search){

      if(key == "searchText"){
        param['searchText'] = this.search.searchText.value;
        continue;
      }

      param[key] = this.search[key];

    }

    if(this.router.url.indexOf("?") == -1){
      this.router.navigate(['/eval/evalList'],{
        queryParams: param,
        relativeTo: this.route,
        queryParamsHandling: "merge",
        replaceUrl:true
      })
    }else{
      this.router.navigate(['/eval/evalList'],{
        queryParams: param,
        relativeTo: this.route,
        queryParamsHandling: "merge",
      })
    }
  }

  evalSearch(param:any){

    this.loading.search = 1;

    this.evalService.evalSearch(param).subscribe(x=>{
        this.loading.search  = 0;
        let status = x[RESULT.RESULT_KEY];
        let data = x[RESULT.DATA_KEY];
        
        if(status == 200){

          this.evalData.list = data;
          this.page.evalData.totalSize = x[RESULT.TOTALSIZE_KEY];

          for(var i =0; i<this.evalData.list.length; i++){
            let eval_item_data = this.evalData.list[i];
            if(eval_item_data['ev_value'] >= 1 && eval_item_data['ev_value'] <= 3)
            {
              eval_item_data['ev_value_class_name'] = 'gray';
            }else if(eval_item_data['ev_value'] >= 4 && eval_item_data['ev_value'] <= 5){
              eval_item_data['ev_value_class_name'] = 'blue';
            }else if(eval_item_data['ev_value'] >= 6 && eval_item_data['ev_value'] <= 7){
              eval_item_data['ev_value_class_name'] = 'yellow';
            }
            
            this.evalData.list[i] = eval_item_data;

         
            this.evalShow(i);
      
            
          }

        }

    },error=>{
      console.log(error);
      this.loading.search = 0;
    })
  }

  order3Change(event: any,order3:number){


    if(event == 0){
      
      this.show.wordSearchStr = "코멘트"
      this.show.wordSearchDialogue = "Search the Evaluation Comment Words";

    }else if(event == 1){

      this.show.wordSearchStr = "소재";
      this.show.wordSearchDialogue = "Search the Evaluation SubjectMatter Words"

    }

  }

/**
 * loading complete jquery effect 
 * */
  evalShow(i:number){
    setTimeout(()=>{
    $("#eval_con_" + i).addClass("loadingComplete");
    console.log("#eval_con_" + i);
  },500 * (i+1));

  }


  /**
   * go to Detail of evalItem detail
   */
  goToDetail(item:any){
    this.router.navigate(["/eval/evalDetail",item.eval_item_id]);
  }


  

}
