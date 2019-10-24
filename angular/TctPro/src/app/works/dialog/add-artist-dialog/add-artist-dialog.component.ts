import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { CdkDragDrop } from '@angular/cdk/drag-drop';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';

declare const $:any;

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
    }

  }

  constructor(public dialogRef: MatDialogRef<AddArtistDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    let data:[] = this.data['list'];

    if(data.length !=0){
      this.art_create_list = data;
      for(var i =0; i<this.works_list.length; i++){
        let item:any = this.works_list[i];
        if(this.checkArtist_isSelected(item) != -1){
          this.artist.checkBox.list[i] = true;
        }
      }
    }

  }

  works_list = [
    {artist_id:1, name:'Get to work'} ,
    {artist_id:2,name:'Pick up groceries'},
    {artist_id:3,name:'Go home'},
    {artist_id:4,name:'Fall asleep'},
    {artist_id:5, name:'Get to work'} ,
    {artist_id:6,name:'Pick up groceries'},
    {artist_id:7,name:'Go home'},
    {artist_id:8,name:'Fall asleep'},
    {artist_id:9, name:'Get to work'} ,
    {artist_id:10,name:'Pick up groceries'},
    {artist_id:11,name:'Go home'},
    {artist_id:12,name:'Fall asleep'},
    {artist_id:13, name:'Get to work'} ,
    {artist_id:14,name:'Pick up groceries'},
    {artist_id:15,name:'Go home'},
    {artist_id:16,name:'Fall asleep'},
  ];

  // works_list_pro ={
  //   page : 1,
  //   pageSize: 5,
  //   pageChange:()=>{
  //     console.log(this.works_list_pro.page);
  //   },
  // }

  art_create_list = [
  ];

  confirm() {
    this.dialogRef.close(this.art_create_list);
  }

  close(){
    this.dialogRef.close();
  }

  drop(event: CdkDragDrop<string[]>) {
    console.log(event);
  }

  /*******************아티스트 선택하는 함수*************************/

  checkAddArtist(event: Event,index:number) {
    console.log(event);
    this.artist.step.list = -1;

    let item = this.works_list[index];
    let result:number = this.checkArtist_isSelected(item); 

    if(result == -1){
      this.art_create_list.push(this.works_list[index]);
    }else{
      this.art_create_list.splice(result,1);
    }
  }

  addArtist(index: number):number {

    let item = this.works_list[index];
    let result:number = this.checkArtist_isSelected(item); 

    //아티스트는 현재 등록되지 않아야 하니까
    if(result != -1){
      return -1;
    }

    this.artist.checkBox.list[index] = true;
    this.artist.step.list = -1;
    this.art_create_list.push(Object.assign({},item));

    return 1;

  }

  removeArtist(index: number):number {

    let item = this.works_list[index];
    let result:number = this.checkArtist_isSelected(item); 

    if(result == -1){
      return -1;
    }

    this.artist.checkBox.list[index] = false;
    this.art_create_list.splice(result,1);
    this.artist.step.list = -1;
    return 1;

  }

  setStepList(event:Event,index: number) {
    //panel 열때 event는 undeifined
    //열떄만 밑의 에니메이션 작동

    this.artist.step.list = index;
    setTimeout(()=>{
      let currentScroll:number = $(".artist_search_list").eq(0).scrollTop();
      let top:number  = currentScroll +  $("#w_" + index).offset().top;
      let diff:number = $(".artist_search_list").offset().top;
      $("#artist_search_list").animate({scrollTop:top - diff -50}, 500,()=>{
        // console.log($("#artist_search_list").scrollTop());
        // console.log($("#w_" + index).offset().top);
      });
    },200);
    
    

  }

  /*******************끝*************************/

  
  /************선택된 아티스트 함수****************/


  removeSelArtist(index: number) {

    let work_index = this.getArtistIndex_fromSelected(this.art_create_list[index])
    if(work_index != -1){
      this.artist.checkBox.list[work_index] = false;
    }
    this.artist.step.sel_list = -1;
    this.art_create_list.splice(index,1);

  }

  setStepSelList(index: number) {
    this.artist.step.sel_list = index;
    // console.log(this.artist.step.list);
    // console.log(index);
  }

  /***********************끝**********************/

  checkArtist_isSelected(item:any):number{

    //판단
    //addSelArtist에 해당 아티스트가 없으면 -1 리턴
    //addSelArtist에 해당 아티스트가 있으면 해당 index 넘버 리턴
    let result:number = -1;

      for(var j =0; j<this.art_create_list.length; j++){
        if(this.art_create_list[j]['artist_id'] == item['artist_id']){
          return j;
        }
      }

      return result;
    }

    getArtistIndex_fromSelected(item:any):number{
      let result:number = -1;
      for(var i =0; i<this.works_list.length; i++){
        if(this.works_list[i]['artist_id'] == item['artist_id']){
          return i ;
        }
      }
      return result;
    }

    removeEventEffectAnymore(event:Event){
      event.stopPropagation();
    }


}
