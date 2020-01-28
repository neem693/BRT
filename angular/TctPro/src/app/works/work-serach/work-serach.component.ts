import { Component, OnInit, ViewChild, QueryList, AfterViewInit, Input, OnChanges, SimpleChanges, ElementRef } from '@angular/core';
import { SwiperConfigInterface, SwiperPaginationInterface, SwiperDirective, SwiperComponent } from 'ngx-swiper-wrapper';
import { WorksSerivceService } from '../works-serivce.service';
import { FormControl, Validators } from '@angular/forms';
import { RESULT } from 'src/const/publicConst';
import { environment } from 'src/environments/environment';
import { HttpParams } from '@angular/common/http';
import { Router, ActivatedRoute, Params } from '@angular/router';

declare const $: any;

@Component({
  selector: 'app-work-serach',
  templateUrl: './work-serach.component.html',
  styleUrls: ['./work-serach.component.css']
})
export class WorkSerachComponent implements OnInit, AfterViewInit {


  public config: SwiperConfigInterface = {
    slideToClickedSlide: true,
    loop: true,
    direction: 'horizontal',
    slidesPerView: 5,
    mousewheel: true,
    centeredSlides: true,
    pagination: { clickable: true, el: '.swiper-pagination' },
  };

  public pagination: SwiperPaginationInterface = {
    el: '.swiper-pagination',
    clickable: true,
    hideOnClick: false
  };

  typeList = {
    data: [],
    type2: [],
    type1Index: 0,
    type2Index: 0,
  }

  dir = {
    image: environment.imageBaseUrl
  }

  /**
   * loading type of some
   * ##search : search loading
   * ##searchItemOrder: loading of item order in searchs
   * ##detail : at least one load of detail
   * 0: detail not load
   * 1: at least one load
   * ##firstLoading: first loading for typeList loading
   * 0: is not loading
   * 1: is loading
   */
  loading = {
    type: 0,
    search: 0,
    searchItemOrder: 0,
    detail: 0,
    firstLoading: 0,
  }
  /**
   * search variable
   * ##order##
   * 0:eval count
   * 1:realse time
   * ##order2##
   * 0:desend
   * 1:accend
   */
  search = {
    type1: 0,
    type2: 0,
    searchText: new FormControl("", [
      Validators.maxLength(60)
    ]),
    order: 0,
    order2: 0,
    pageNum: 1,

  }
  /**
   * works list
   */
  works_list: any[] = [];

  /**
   * targetWork
   * of 
   * Detail
   */
  targetWork = {
    work: {
      type2:{
        type2_name:"",
        type1Dto:{
          type1_name:""
        }
      },
      create_date:"",
      create_date2:"",
      subject:"",
      work_id:0,
      artistDtoList:[],
      fileSaveDto:[{
        file_path:"",
        save_file_name:""
      }],
      is_series:0
    },
    matter: {},
    matterSize: 0,
  };
  page = {
    worksList: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10,
    },
    matter: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10
    }
  }

  /**
   * detail target
   * picIntdex: target of detail picture of work index
   * loading: loading detail
   * 0: loading complete
   * 1: loading doing~~
   * 
   */
  detail = {
    picIndex: 0,
    detailLoad: 0,

  }

  // swiper = {
  //   type1Index: 0,
  //   type2Index: 0
  // }

  private swiperType1: SwiperComponent;
  private swiperType2: SwiperComponent;

  @ViewChild('type1', { static: false }) set swiperType1_viewchild(content: SwiperComponent) {
    this.swiperType1 = content;
  }
  @ViewChild('type2', { static: false }) set swiperType2_viewchild(content: SwiperComponent) {
    this.swiperType2 = content;
  }

  constructor(private workService: WorksSerivceService
    , private router: Router
    , private route: ActivatedRoute) { }

  ngOnInit() {

    this.getAllType();
    //this.worksSearchNativeUrl(1);
    this.route.paramMap.subscribe(x => {
      console.log(x);
      let data = x['params'];
      if (data['id'] != undefined && data['id'] != 0) {
        this.searchWorksDetail(data['id']);
      }else if(data['id'] == 0){
        $(".work_detail_outer").removeClass("active");
      }

      if (this.router.url.split("?").length == 1) {
        this.worksSearchNativeUrl(1);
      }

    })

    this.route.queryParams.subscribe(x => {
      console.log(x);
      if (x['type1'] != null) {

        if (this.loading.type == 0) {
          this.search.type1 = x['type1'];
          this.search.type2 = x['type2'];
        }

        this.worksSearch(x);
      }
    })

  }

  ngAfterViewInit(): void {

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
            }, 1000)

          }
        }

        this.loading.firstLoading = 1;

      }, 1000);


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

  worksSearchNativeUrl(page: number) {

    let data = {};

    for (let key in this.search) {
      if (key == "searchText") {
        if (this.search[key]['errors'] != null) {
          alert("형식을 확인해주세요.");
          return;
        }
        data[key] = this.search[key]['value'];
        continue;
      }
      data[key] = this.search[key];
    }
    data['pageNum'] = page;

    let param: Params = {};
    for (let key in data) {
      param[key] = data[key];
    }

    console.log(this.router.url.indexOf("?"));

    //is first search??
    //yes
    if(this.router.url.indexOf("?") == -1){ 
      this.router.navigate(['.'], {
        relativeTo: this.route,
        queryParams: param,
        queryParamsHandling: "merge",
        replaceUrl: true
      })
      //no
    }else{
      this.router.navigate(['.'], {
        relativeTo: this.route,
        queryParams: param,
        queryParamsHandling: "merge"
      })
    }

    this.worksSearch(data);

  }

  worksSearch(data: any) {

    //loading search
    this.loading.search = 1;
    //loading 
    this.loading.searchItemOrder = 1;
    this.workService.worksSearch(data).subscribe(x => {
      let result = x[RESULT.RESULT_KEY]
      if (result == 200) {
        let return_data = x[RESULT.DATA_KEY];
        this.works_list = Object.assign([], return_data);
        if (this.works_list.length != 0) {
          this.page.worksList.totalSize = this.works_list[0]['totalSize'];
        } else {
          this.page.worksList.totalSize = 0;
        }
      }
      this.loading.search = 0;

      for(var i =0; i<this.works_list.length; i++){
        this.work_item_index(i);
        
      }

    })

  }

 
  /**
   * searchChange function
   * searchParam change trigger this function
   * @param event 
   */
  searchChange(event: any) {
    // console.log(event);
  }

  //animation css remove

  searchWorksDetail(workId: any) {

    //detail picture index reset
    this.detail.picIndex = 0;

    this.loading.detail = 1;
    $(".work_detail_outer").removeClass("active");
    this.workService.worksSearchDetail({ 'work_id': workId, 'pageNum': this.page.matter.pageNum }).subscribe(x => {
      let result = x[RESULT.RESULT_KEY];
      let data = null
      if (result == 200) {
        data = x[RESULT.DATA_KEY];
      }
      this.targetWork.work = data['work'];
      this.targetWork.matter = data['matter'];
      this.targetWork.matterSize = data['matterSize'];
      this.page.matter.totalSize = this.targetWork.matterSize;
      console.log(this.page.matter.totalSize);
      this.detail.detailLoad = 1;
      this.loading.detail = 0;
      // console.log(this.targetWork);

      //animation css
      setTimeout(()=>{
        $(".work_detail_outer").addClass("active");
      },600);


    }, error => {
      this.loading.detail = 0;
    })

  }

  /**
   * 
   * @param workId 
   * IMPORTANT
   * detail:1 param is only detailSearch Other 0
   */
  searchWorksDetailNativeUrl(workId: number) {
    console.log(workId);
    //reference the togglefold function
    $("#detail_outer").removeClass('fold');
    this.router.navigate(['/works/search', workId], {
      queryParamsHandling: "merge"
    });
  }

  changeDetailPicIndex(index: number) {
    this.detail.picIndex = index;
  }

  /**
   * when use the dynamic query for small screen, detail edge show the icon fold the detail view
   */
  toggleFold() {

    $("#detail_outer").toggleClass("fold");

  }

  /**
   * work item animation
   * @param index 
   */
  work_item_index(index: number) {
    
    setTimeout(() => {
      $("#workItem" + index).addClass("active");
    }, 200* (index+1));
    
  }


  registEval(){
    
    let work_id = this.targetWork.work['work_id'];
    this.router.navigate(['/eval/addEval/',work_id]);
    

  }



}
