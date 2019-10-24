import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-login-fail',
  templateUrl: './login-fail.component.html',
  styleUrls: ['./login-fail.component.css']
})
export class LoginFailComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<LoginFailComponent>, @Inject(MAT_DIALOG_DATA)public data:any ) { }

  ngOnInit() {
  }

  close(){
    this.dialogRef.close();
  }

}
