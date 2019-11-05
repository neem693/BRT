import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-matter-select-dialog',
  templateUrl: './matter-select-dialog.component.html',
  styleUrls: ['./matter-select-dialog.component.css']
})
export class MatterSelectDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<MatterSelectDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  matterInfo_list = [
    { 'sub_name': '소재1', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재2', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재3', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재4', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재5', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재6', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재7', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재8', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재9', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재11', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재12', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재13', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재14', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재15', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재16', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재17', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재18', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
    { 'sub_name': '소재19', 'yellow': 32, 'blue': 30, 'gray': 23, 'black': 10 },
  ]

  matter = {
    page: {
      totalSize: 19,
      pageNum: 1
    }
  }

  ngOnInit() {
  }

  confirm() {

  }

  close() {
    this.dialogRef.close();
  }

}
