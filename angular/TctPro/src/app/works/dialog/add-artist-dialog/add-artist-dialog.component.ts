import { Component, OnInit, Inject, ViewChildren, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { CdkDragDrop } from '@angular/cdk/drag-drop';
import { ArtistService } from 'src/app/artist/artist.service';
import * as moment from 'moment';
import { WorksSerivceService } from '../../works-serivce.service';

declare const $: any;

@Component({
  selector: 'app-add-artist-dialog',
  templateUrl: './add-artist-dialog.component.html',
  styleUrls: ['./add-artist-dialog.component.css']
})
export class AddArtistDialogComponent implements OnInit {


  artist = {
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

  constructor(
    public dialogRef: MatDialogRef<AddArtistDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public artistService: ArtistService,
    public worksService: WorksSerivceService) { }

  ngOnInit() {

    let data: [] = this.data['list'];

    if (data.length != 0) {
      this.art_create_list = data;
      for (var i = 0; i < this.artist_list.length; i++) {
        let item: any = this.artist_list[i];
        if (this.checkArtist_isSelected(item) != -1) {
          this.artist.checkBox.list[i] = true;
        }
      }
    }

  }

  artist_list = [

  ];

  // works_list_pro ={
  //   page : 1,
  //   pageSize: 5,
  //   pageChange:()=>{
  //     console.log(this.artist_list_pro.page);
  //   },
  // }

  art_create_list = [
  ];

  confirm() {
    this.dialogRef.close(this.art_create_list);
  }

  close() {
    this.dialogRef.close();
  }

  drop(event: CdkDragDrop<string[]>) {
    console.log(event);
  }

  /*******************아티스트 선택하는 함수*************************/

  checkAddArtist(event: Event, index: number) {
    console.log(event);
    this.artist.step.list = -1;

    let item = this.artist_list[index];
    let result: number = this.checkArtist_isSelected(item);

    if (result == -1) {
      this.art_create_list.push(this.artist_list[index]);
    } else {
      this.art_create_list.splice(result, 1);
    }
  }

  addArtist(index: number): number {

    let item = this.artist_list[index];
    let result: number = this.checkArtist_isSelected(item);

    //아티스트는 현재 등록되지 않아야 하니까
    if (result != -1) {
      return -1;
    }

    this.artist.checkBox.list[index] = true;
    this.artist.step.list = -1;
    this.art_create_list.push(Object.assign({}, item));

    return 1;

  }

  removeArtist(index: number): number {

    let item = this.artist_list[index];
    let result: number = this.checkArtist_isSelected(item);

    if (result == -1) {
      return -1;
    }

    this.artist.checkBox.list[index] = false;
    this.art_create_list.splice(result, 1);
    this.artist.step.list = -1;
    return 1;

  }

  setStepList(event: Event, index: number) {
    //panel 열때 event는 undeifined
    //열떄만 밑의 에니메이션 작동

    this.artist.step.list = index;
    setTimeout(() => {
      let currentScroll: number = $(".artist_search_list").eq(0).scrollTop();
      let top: number = currentScroll + $("#w_" + index).offset().top;
      let diff: number = $(".artist_search_list").offset().top;
      $("#artist_search_list").animate({ scrollTop: top - diff - 50 }, 500, () => {
        // console.log($("#artist_search_list").scrollTop());
        // console.log($("#w_" + index).offset().top);
      });
    }, 200);

    // let targetArtist = Object.assign({},this.artist_list[index]);
    // this.worksService.selectWorksByArtistOnes()

  }

  /*******************끝*************************/


  /************선택된 아티스트 함수****************/


  removeSelArtist(index: number) {

    let work_index = this.getArtistIndex_fromSelected(this.art_create_list[index])
    if (work_index != -1) {
      this.artist.checkBox.list[work_index] = false;
    }
    this.artist.step.sel_list = -1;
    this.art_create_list.splice(index, 1);

  }

  setStepSelList(index: number) {
    this.artist.step.sel_list = index;
    // console.log(this.artist.step.list);
    // console.log(index);
  }

  /***********************끝**********************/

  checkArtist_isSelected(item: any): number {

    //판단
    //addSelArtist에 해당 아티스트가 없으면 -1 리턴
    //addSelArtist에 해당 아티스트가 있으면 해당 index 넘버 리턴
    let result: number = -1;

    for (var j = 0; j < this.art_create_list.length; j++) {
      if (this.art_create_list[j]['artist_id'] == item['artist_id']) {
        return j;
      }
    }

    return result;
  }

  getArtistIndex_fromSelected(item: any): number {
    let result: number = -1;
    for (var i = 0; i < this.artist_list.length; i++) {
      if (this.artist_list[i]['artist_id'] == item['artist_id']) {
        return i;
      }
    }
    return result;
  }

  removeEventEffectAnymore(event: Event) {
    event.stopPropagation();
  }

  /**아티스트 이름으로 검색 */
  selectArtistList(page: number) {

    let pageNum: number = page;
    let searchText: string = this.artist.searchText;

    let data = {};
    data['pageNum'] = pageNum;
    data['searchText'] = searchText;

    this.artistService.selectArtistList(data).subscribe(x => {

      this.artist_list = x['data'];
      this.artist.totalSize.list = x['totalSize'];

      this.artist.step.list = -1;

      // console.log(this.artist_list[0]['add_date']);
      // let date = moment(this.artist_list[0]['add_date']).format("YYYY-MM-DD HH:mm:ss");
      // console.log(date);

      loop: for (var i = 0; i < this.artist_list.length; i++) {
        for (var j = 0; j < this.art_create_list.length; j++) {
          if (this.artist_list[i].artist_id == this.art_create_list[j].artist_id) {
            this.artist.checkBox.list[i] = true;
            continue loop;
          }
        }
        this.artist.checkBox.list[i] = false;
      }

    })

  }


}
