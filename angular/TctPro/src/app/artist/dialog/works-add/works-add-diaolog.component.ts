import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';

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



}
