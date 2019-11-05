import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { MatterSelectDialogComponent } from '../dialog/matter-select-dialog/matter-select-dialog.component';

@Component({
  selector: 'app-add-eval',
  templateUrl: './add-eval.component.html',
  styleUrls: ['./add-eval.component.css']
})
export class AddEvalComponent implements OnInit {
  /**
   * ##button1##
   * -1: initialize
   * 1: not good
   * 2: good
   * 3: veryGood
   * ##button2##
   * -1: initialize
   * 1: warning
   * 2: bad
   * 3: not good
   * 4: good
   * 5: reco
   * 6: verygood
   * 7: excellent
   * ##ev_text1##
   * FormControll
   * ##ev_text2##
   * FormControll
   * ##subjectMatter##
   * FormControll
   * ##matterIsNew##
   * 0: is not new, only read only, need pop up get single subjectmatter was aleready evaled;
   * 1: is new, edit the FormControll value menually
   */
  eval = {
    button1: -1,
    button2: -1,
    ev_text1: new FormControl("", [
      Validators.required,
      Validators.maxLength(50)
    ]),
    ev_text2: new FormControl("", [
      Validators.required,
      Validators.maxLength(50)
    ]),
    subjectMatter: new FormControl("", [
      Validators.required,
      Validators.maxLength(30)
    ]),
    matterIsNew: 0
  }

  /**
   * hoverSelect
   * -1: initilize
   * 1: warning hover
   * 2: bad hover
   * 3: not good hover
   * 4: good hover
   * 5: reco hover
   * 6: verygood hover
   * 7: excellent hover
   */
  evalHoverSelect: number = -1;

  work={
    id:0
  }

  constructor(
    private route:ActivatedRoute,
    private router:Router,
    private dialog:MatDialog
    ) { }

  ngOnInit() {
    
    this.route.params.subscribe(x=>{
      if(x['id'] == null){
        this.router.navigate(["home"]);
        return;
      }
      this.work.id = x['id'];
    })

  }

  /** not set button2, but show looks like button2 really set function */
  button2Hover(value: number) {
    this.evalHoverSelect = value;
  }

  /** eval shape color when hidden ng class function */
  evalButtonHiddenSetting(value: number): boolean {

    let result: boolean = false;
    let button2IsSelect:boolean = this.eval.button2 == value

    switch (value) {
      case 1:
      case 2:
      case 3:
        //eval button1 is not select && eval button1 is not initialize BUT eval button 2 all color not hover or selected one
        result = (this.eval.button1 != 1 && this.eval.button1 != -1) || this.evalHoverSelect != -1 || this.eval.button2 != -1;  
        break;
      case 4:
      case 5:
        result = (this.eval.button1 != 2 && this.eval.button1 != -1) || this.evalHoverSelect != -1 || this.eval.button2 != -1
        break;
      case 6:
      case 7:
        result = (this.eval.button1 != 3 && this.eval.button1 != -1) || this.evalHoverSelect != -1 || this.eval.button2 != -1
        break;
    }

    return result;
    // eval.button1 != 1 && eval.button1 != -1
  }

  button2Set(value:number){
    this.eval.button2 = value;
  }
  
  button1Set(value:number){
    this.eval.button2 = -1;
    this.eval.button1 = value;
  }

  matDialogOpen(){

    if(this.eval.matterIsNew == 1){
      return;
    }
    
    let dialogRef = this.dialog.open(MatterSelectDialogComponent,{
      data:{
        'id':this.work.id
      }
    })
    
    dialogRef.afterClosed().subscribe(x=>{
      console.log(x);
    })

  }

}
