import { Injectable } from '@angular/core';
import { GlobalDialogComponent } from './dialog/global-dialog/global-dialog.component';
import { MatDialog, MatDialogRef } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class GlobalServiceService {

  constructor(
    private dialog:MatDialog
    ) { }

  public openGlobalAlert(_message:string):MatDialogRef<GlobalDialogComponent, any>{
    let dialogRef = this.dialog.open(GlobalDialogComponent, {

      data: { message: _message },

    })

    return dialogRef;
  }
}
