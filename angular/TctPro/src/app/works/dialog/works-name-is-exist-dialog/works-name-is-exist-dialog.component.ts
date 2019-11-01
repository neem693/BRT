import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { WorksSerivceService } from '../../works-serivce.service';
import { FormControl, Validators } from '@angular/forms';
import { RESULT } from 'src/const/publicConst';

declare const $: any

@Component({
  selector: 'app-works-name-is-exist-dialog',
  templateUrl: './works-name-is-exist-dialog.component.html',
  styleUrls: ['./works-name-is-exist-dialog.component.css']
})
export class WorksNameIsExistDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<WorksNameIsExistDialogComponent>,
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
    type1: new FormControl(0, [
      // Validators.required
    ]),
    type2: new FormControl(0, [
      // Validators.required
    ]),
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

  typeList = {
    data: [],
    type2: []
  }

  ngOnInit() {
    this.works_list = Object.assign([], this.data.list);
    this.works.totalSize.list = this.data.page.totalSize;
    this.works.searchText = this.data.subject;
    this.getAllType();
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

  }

  selectWorkListDetail(page: number) {
    let pageNum = page;
    let searchText = this.works.searchText;
    if (searchText == null || searchText == undefined) {
      searchText = "";
    }
    let type = {
      type1: 0,
      type2: 0,
    }

    // console.log(this.works.type2.value);

    if (this.works.type1.value != "") {
      if (this.works.type2.value != "") {
        type.type2 = this.works.type2.value;
      }
      type.type1 = this.works.type1.value;
    }

    let data = {
      'pageNum': pageNum,
      'searchText': searchText,
      'type1Value': type.type1,
      'type2Value': type.type2,
    }

    this.workService.worksSelectListDetail(data).subscribe(x => {
      this.works_list = x[RESULT.DATA_KEY];
      this.works.totalSize.list = x[RESULT.TOTALSIZE_KEY];
      this.works.step.list = -1;

      loop: for (var i = 0; i < this.works_list.length; i++) {
        for (var j = 0; j < this.added_works_list.length; j++) {

          if (this.works_list[i]['work_id'] == this.added_works_list[j]['work_id']) {
            this.works.checkBox.list[i] = true;
            continue loop;
          }

        }
        this.works.checkBox.list[i] = false;
      }

    });


  }
  /*************모든 타입 불러오기********** */
  getAllType() {

    this.workService.getAllWorkType().subscribe((result) => {
      this.typeList.data = Object.assign([], result);
      // console.log(typeList);
    });

  }

  /********* tpye1 값 바뀌었을 때 type2 값 바꾸기********* */
  type1Select(id: number) {

    if (id == undefined) {
      return;
    } else if (id == 0) {
      this.typeList.type2 = [];
    } else {

      for (let type1 of this.typeList.data) {
        if (type1.type1_id == id) {
          this.typeList.type2 = Object.assign([], type1['type2Dto']);
        }

      }
    }
    this.works.type2.setValue(0);
    this.selectWorkListDetail(1);

  }

  /********* tpye1 값 바뀌었을 때 type2 값 바꾸기********* */
  type2Select(id: number) {

    this.selectWorkListDetail(1);

  }

  /**continue because not added in current db */
  continue(){
    this.dialogRef.close(1);
  }

  /**move to One work */
  moveToWork(ww:any){
    console.log(ww);
  }

}
