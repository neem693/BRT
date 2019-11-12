import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { EvalService } from '../../eval.service';
import { RESULT } from 'src/const/publicConst';

@Component({
  selector: 'app-matter-select-dialog',
  templateUrl: './matter-select-dialog.component.html',
  styleUrls: ['./matter-select-dialog.component.css']
})
export class MatterSelectDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<MatterSelectDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private evalService:EvalService
    ) { }

  matterInfo_list = [
    // { 'subjectMatter': '소재1', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재2wefwefweffwfwfwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재3', 'yellow': 32, 'blue': 0, 'gray': 23, 'black': 0 },
    // { 'subjectMatter': '소재4', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재5', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재6', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재7', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재8', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재9', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재11', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재12', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재13', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재14', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재15', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재16', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재17', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재18', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    // { 'subjectMatter': '소재19', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
  ]

  matter = {
    page: {
      totalSize: 19,
      pageNum: 1,
      pageSize: 10,
    },
    select: {
      squence: -1
    },
  }
  /**
   * ##returnData dataInfo##
   * 0: matter info
   * 1: new_matterInfo
   * ##data###
   * if matterInfo is 0 has data of matter */
  returnData= {
    matter_info: 0,
    data:{},
  }

  ngOnInit() {

    this.getMatterList(1);

  }

  /** matter set already regist matter */
  confirm() {

    if(this.matter.select.squence == -1){
      alert("오류가 발생했습니다: 소재 선택 필요");
      return;
    }

    this.returnData.matter_info =0;
    this.returnData.data = this.matterInfo_list[this.matter.select.squence];
    
    let data = Object.assign({},this.returnData);

    this.dialogRef.close(data);

  }

  /**new matter data */
  close() {
    this.returnData.matter_info =1;

    let data = Object.assign({},this.returnData);

    this.dialogRef.close(data);
  }

  selectMatList(page: number) {

    this.matter.select.squence = -1;

  }

  selectMatterOne(index: number) {

    this.matter.select.squence = index;

  }

  getMatterList(pageNum:number){
    let param = {};
    param['work_id'] = this.data['id'];
    param['pageNum'] = pageNum;

    this.evalService.getMatter(param).subscribe(x=>{
      this.matter.page.totalSize = x[RESULT.TOTALSIZE_KEY];
      this.matterInfo_list = x[RESULT.DATA_KEY];
    })
  }

}
