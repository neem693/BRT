import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-join-fail',
  templateUrl: './join-fail.component.html',
  styleUrls: ['./join-fail.component.css']
})
export class JoinFailComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<JoinFailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  close():void{
    this.dialogRef.close();
  }

}
