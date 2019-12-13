import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { RESULT } from 'src/const/publicConst';
import { environment } from 'src/environments/environment';

declare const $: any;

@Component({
  selector: 'app-works-add',
  templateUrl: './works-add-diaolog.component.html',
  styleUrls: ['./works-add-diaolog.component.css']
})
export class WorksAddComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<WorksAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private workService: WorksSerivceService) { }

  works = {
    checkBox: {
      list: [],
      sel_list: [],
    },
    step: {
      list: -1,
      sel_list: -1,
    },
    pageSize: {
      list: 10,
      sel_list: 0
    },
    totalSize: {
      list: 0,
      sel_list: 0
    },
    searchText: "",
    pageNum: 1,
  }
  

  works_list = [
    // {artist_id:1, name:'Get to work'} ,
    // {artist_id:2,name:'Pick up groceries'},
    // {artist_id:3,name:'Go home'},
    // {artist_id:4,name:'Fall asleep'},
    // {artist_id:5, name:'Get to work'} ,
    // {artist_id:6,name:'Pick up groceries'},
    // {artist_id:7,name:'Go home'},
    // {artist_id:8,name:'Fall asleep'},
    // {artist_id:9, name:'Get to work'} ,
    // {artist_id:10,name:'Pick up groceries'},
    // {artist_id:11,name:'Go home'},
    // {artist_id:12,name:'Fall asleep'},
    // {artist_id:13, name:'Get to work'} ,
    // {artist_id:14,name:'Pick up groceries'},
    // {artist_id:15,name:'Go home'},
    // {artist_id:16,name:'Fall asleep'},
  ];

  added_works_list = [
   
  ]

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

     /**
   * selected detail target
   * picIntdex: target of detail picture of work index
   * loading: loading detail
   * 0: loading complete
   * 1: loading doing~~
   * 
   */
  selDetail = {
    picIndex: 0,
    detailLoad: 0,

  }

    /**
   * loading type of some
   * ##search : search loading
   * ##searchItemOrder: loading of item order in searchs
   * ##detail : at least one load of detail
   * 0: detail not load
   * 1: at least one load
   * ##selDetail : at least one load of selected detail
   * 0: selDetail not load
   * 1: at least one selDetail load
   * ##firstLoading: first loading for typeList loading
   * 0: is not loading
   * 1: is loading
   */
  loading = {
    type: 0,
    search: 0,
    searchItemOrder: 0,
    detail: 0,
    selDetail:0,
    firstLoading: 0,
  }

  page = {
    matter: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10
    },
    selMatter : {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10,
    }
  }

  /**
   * targetWork
   * of 
   * Detail
   */
  targetWork = {
    work: {},
    matter: {},
    matterSize: 0,
  };

   /**
   * targetWork
   * of 
   * selected Detail
   */
  selTargetWork = {
    work: {},
    matter: {},
    matterSize: 0,
  };

  dir = {
    image: environment.imageBaseUrl
  }

  ngOnInit() {
    this.added_works_list = Object.assign([],this.data.list);
  }

  confirm() {
    this.dialogRef.close(this.added_works_list);
  }

  close() {
    this.dialogRef.close();
  }

  removeEventEffectAnymore(event: Event) {
    event.stopPropagation();
  }

  addWorks(index: number): number {

    let item = this.works_list[index];
    let result: number = this.checkArtist_isSelected(item);

    //저작물이 중복되지 않아야 하니까
    if (result != -1) {
      return -1;
    }

    this.works.checkBox.list[index] = true;
    this.works.step.list = -1;
    this.added_works_list.push(Object.assign({}, item));

    return 1;

  }

  checkArtist_isSelected(item: any): number {

    //판단
    //addSelWorks에 해당 저작물이 없으면 -1 리턴
    //addSelWorks에 해당 저작물이 있으면 해당 index 넘버 리턴
    let result: number = -1;

    for (var j = 0; j < this.added_works_list.length; j++) {
      if (this.added_works_list[j]['work_id'] == item['work_id']) {
        return j;
      }
    }

    return result;
  }

  checkAddArtist(event: Event, index: number) {
    console.log(event);
    this.works.step.list = -1;

    let item = this.works_list[index];
    let result: number = this.checkArtist_isSelected(item);

    if (result == -1) {
      this.added_works_list.push(this.works_list[index]);
    } else {
      this.added_works_list.splice(result, 1);
    }
  }

  setStepSelList(index: number) {
    this.works.step.sel_list = index;
    // console.log(this.artist.step.list);
    // console.log(index);

    let work_id = this.added_works_list[index].work_id;
    this.searchSelWorksDetail(work_id);
  }

  removeSelArtist(index: number) {

    let work_index = this.getWorksIndex_fromSelected(this.added_works_list[index])
    if (work_index != -1) {
      this.works.checkBox.list[work_index] = false;
    }
    this.works.step.sel_list = -1;
    this.added_works_list.splice(index, 1);

  }

  getWorksIndex_fromSelected(item: any): number {
    let result: number = -1;
    for (var i = 0; i < this.works_list.length; i++) {
      if (this.works_list[i]['work_id'] == item['work_id']) {
        return i;
      }
    }
    return result;
  }

  setStepList(event: Event, index: number) {
    //panel 열때 event는 undeifined
    //열떄만 밑의 에니메이션 작동

    this.works.step.list = index;
    setTimeout(() => {
      let currentScroll: number = $(".work_search_list").eq(0).scrollTop();
      let top: number = currentScroll + $("#w_" + index).offset().top;
      let diff: number = $(".work_search_list").offset().top;
      $("#work_search_list").animate({ scrollTop: top - diff - 50 }, 500, () => {
        // console.log($("#artist_search_list").scrollTop());
        // console.log($("#w_" + index).offset().top);
      });
    }, 200);

     let work_id = this.works_list[index].work_id;
     this.searchWorksDetail(work_id);

  }

  selectWorkList(page: number) {
    let pageNum = page;
    let searchText = this.works.searchText;
    if (searchText == null || searchText == undefined) {
      searchText = "";
    }

    let data = {
      'pageNum': pageNum,
      'searchText': searchText
    }

    this.workService.worksSelectList(data).subscribe(x => {
      this.works_list = x['data'];
      this.works.totalSize.list = x['totalSize'];
      this.works.step.list = -1;

      loop: for (var i = 0; i < this.works_list.length; i++) {
        for (var j = 0; j < this.added_works_list.length; j++) {

          if(this.works_list[i]['work_id'] ==this.added_works_list[j]['work_id']){
            this.works.checkBox.list[i] = true;
            continue loop;
          }

        }
        this.works.checkBox.list[i] = false;
      }

    });


  }


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

  //already selected work
  searchSelWorksDetail(workId: any) {

    //detail picture index reset
    this.selDetail.picIndex = 0;

    this.loading.selDetail = 1;
    $(".work_detail_outer").removeClass("active");
    this.workService.worksSearchDetail({ 'work_id': workId, 'pageNum': this.page.matter.pageNum }).subscribe(x => {
      let result = x[RESULT.RESULT_KEY];
      let data = null
      if (result == 200) {
        data = x[RESULT.DATA_KEY];
      }
      this.selTargetWork.work = data['work'];
      this.selTargetWork.matter = data['matter'];
      this.selTargetWork.matterSize = data['matterSize'];
      this.page.selMatter.totalSize = this.selTargetWork.matterSize;
      this.selDetail.detailLoad = 1;
      this.loading.selDetail = 0;
      // console.log(this.targetWork);

      //animation css
      setTimeout(()=>{
        $(".work_detail_outer").addClass("active");
      },600);


    }, error => {
      this.loading.selDetail = 0;
    })

  }

  changeDetailPicIndex(index: number) {
    this.detail.picIndex = index;
  }

  selChangeDetailPicIndex(index: number) {
    this.selDetail.picIndex = index;
  }

    /**
   * when use the dynamic query for small screen, detail edge show the icon fold the detail view
   */
  toggleFold() {

    $("#detail_outer").toggleClass("fold");

  }

  selToggleFold(){

    $("#sel_detail_outer").toggleClass("fold");

  }

}
