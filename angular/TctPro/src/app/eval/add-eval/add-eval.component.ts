import { Component, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatInput } from '@angular/material';
import { MatterSelectDialogComponent } from '../dialog/matter-select-dialog/matter-select-dialog.component';
import { EvalService } from '../eval.service';
import { RESULT } from 'src/const/publicConst';

declare const $: any;
declare const html2canvas:any;



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

  /**work info */
  work = {
    id: 0,
    subject: "",
  }

  /**artist info */
  artist = {
    id: 0,
    totalSize: 0,
    art_name: "",
  }

  /**matter select dialog return data, and this property is same type of return data */
  matterReturnData = {
    matter_info: 0,
    data: {},
  }

  loading = {
    save :0
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private dialog: MatDialog,
    private evalService: EvalService,
  ) { }

  ngOnInit() {

    this.route.params.subscribe(x => {
      if (x['id'] == null) {
        this.router.navigate(["home"]);
        return;
      }
      this.work.id = x['id'];

      this.getWork(this.work.id)

      // setTimeout(()=>{
      //   this.getImage();
      // },500);
   

      

    })

    



  }

  /** not set button2, but show looks like button2 really set function */
  button2Hover(value: number) {
    this.evalHoverSelect = value;
  }

  /** eval shape color when hidden ng class function */
  evalButtonHiddenSetting(value: number): boolean {

    let result: boolean = false;
    let button2IsSelect: boolean = this.eval.button2 == value

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

  button2Set(value: number) {
    this.eval.button2 = value;
  }

  button1Set(value: number) {
    this.eval.button2 = -1;
    this.eval.button1 = value;
  }

  /**
   * 
   * @param type 0: return matterIsNew true 1: not return matterisNew true
   */
  matDialogOpen(type: number) {

    if (this.eval.matterIsNew == 1 && type == 0) {
      return;
    }

    let dialogRef = this.dialog.open(MatterSelectDialogComponent, {
      data: {
        'id': this.work.id,
        'subject': this.work.subject,
      }
    })

    dialogRef.afterClosed().subscribe(x => {

      for (let key in this.matterReturnData) {
        this.matterReturnData[key] = x[key];
      }

      if (this.matterReturnData.matter_info == 1) {

        this.eval.matterIsNew = 1
        $("#matterSubjectInput").removeClass("mat-form-field-hide-placeholder");
        $("#matterSubjectInput").addClass("mat-form-field-should-float mat-focused");
        $("#matterSubjectInput input").focus();

      } else if (this.matterReturnData.matter_info == 0) {

        this.eval.matterIsNew = 0;
        this.eval.subjectMatter.setValue(this.matterReturnData.data['subjectMatter']);

      }

    })

  }

  /**get work method */
  getWork(work_id: number) {

    let data = {};
    data['work_id'] = work_id;

    this.evalService.getWork(data).subscribe(x => {

      let result = x[RESULT.RESULT_KEY];
      if (result == 201) {
        alert("해당 저작물은 존재 하지 않습니다.");
        this.router.navigate(["home"]);
      } else if (result == 202) {
        alert("해당 저작물은 저작자가 등록되지 않았기에 평가 등록이 불가능합니다.");
        this.router.navigate(["home"]);
      }

      let data = x[RESULT.DATA_KEY];

      this.work.subject = data['work']['subject'];
      this.artist.id = data['artist']['artist_id'];
      this.artist.art_name = data['artist']['art_name'];
      this.artist.totalSize = x[RESULT.TOTALSIZE_KEY];

    });

  }

  evalSave() {

    let data = {};

    if (this.eval.button2 == -1) {
      alert("평가를 항목을 끝까지 선택해주세요.");
      return;
    }

    for (let key in this.eval) {

      if (key == "ev_text1"
        || key == "ev_text2"
        || key == "subjectMatter") {

        if (this.eval[key]['error'] != null) {
          alert("형식을 확인해주세요.");
          return;
        }

        data[key] = this.eval[key]['value'];
        continue;

      }
      data[key] = this.eval[key];
    }

    data['work_id'] = this.work.id;
    this.loading.save = 1;
    this.evalService.saveEval(data).subscribe(x=>{
      
    },
    ()=>{this.loading.save = 0;},
    ()=>{
      this.loading.save = 0;
    });

  }

  getImage(){

    // var target = this.targetEvalItem.nativeElement;

    var target = document.body;
    target = document.getElementById("targetEvalItem");
    
    let height = $(window).scrollTop();
    // let target2 = document.getElementById("html2canvasContrainer");

    // target2.innerHTML = target.innerHTML;
    $(window).scrollTop(0);
  
    console.log(height);
    console.log(target);

      html2canvas(target,{allowTaint : true}).then(function(canvas:any) {
        console.log(canvas);
        console.log(canvas.toDataURL('image/png'));
        $("#result").html(canvas);
        $(window).scrollTop(height);
    });

   

   
  }

}
