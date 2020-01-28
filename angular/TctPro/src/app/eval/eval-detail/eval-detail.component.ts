import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EvalService } from '../eval.service';
import { RESULT } from 'src/const/publicConst';
import { environment } from 'src/environments/environment';
import { MatDialog } from '@angular/material';
import { GlobalDialogComponent } from 'src/app/global/dialog/global-dialog/global-dialog.component';

@Component({
  selector: 'app-eval-detail',
  templateUrl: './eval-detail.component.html',
  styleUrls: ['./eval-detail.component.css']
})
export class EvalDetailComponent implements OnInit {

  dir = {
    image: environment.imageBaseUrl
  }

  work = {
    type2: {
      type2_name: "",
      type1Dto: {
        type1_name: ""
      }
    },
    create_date: "",
    create_end_date2: "",
    subject: "",
    work_id: 0,
    artistDtoList: [],
    fileSaveDto: [{
      file_path: "",
      save_file_name: ""
    }],
    is_series: 0,
    img: {},
  }
  eval = {
    id: 0,
    target: {
      work: {
        type2: {
          type2_name: "",
          type1Dto: {
            type1_name: ""
          }
        },
        create_date: "",
        create_end_date2: "",
        subject: "",
        work_id: 0,
        artistDtoList: [],
        fileSaveDto: [{
          file_path: "",
          save_file_name: ""
        }],
        is_series: 0,
        img: {},
        // subjectMatter: "",
        save_file_name: ""
      },
      subjectMatter:"",
      ev_text1: "",
      ev_value: 0,
      ev_text2: "",
      ev_value_class_name:""
    },
   
  }

  /**
   * detail target
   * picIntdex: target of detail picture of work index
   * loading: loading detail
   * 0: loading complete
   * 1: loading doing~~
   * 
   */
  detail = {
    picIndex: 0,
    detailLoad: 0,

  }

  loading = {
    firstLoading: 0,
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private evalService: EvalService,
    private dialog: MatDialog
  ) { }



  ngOnInit() {

    this.route.params.subscribe(x => {
      if (x['id'] == null) {
        this.router.navigate(["home"]);
        return;
      }
      this.eval.id = x['id'];
      console.log(this.eval.id);
      this.getEvalDetail();

    })

  }

  getEvalDetail() {
    this.loading.firstLoading = 1;
    this.evalService.evalDetail({ 'eval_id': this.eval.id }).subscribe(x => {
      let status = x[RESULT.RESULT_KEY];
      this.loading.firstLoading = 0;
      if (status == 200) {
        let data = x[RESULT.DATA_KEY];


        if (data['ev_value'] >= 1 && data['ev_value'] <= 3) {
          data['ev_value_class_name'] = 'gray';
        } else if (data['ev_value'] >= 4 && data['ev_value'] <= 5) {
          data['ev_value_class_name'] = 'blue';
        } else if (data['ev_value'] >= 6 && data['ev_value'] <= 7) {
          data['ev_value_class_name'] = 'yellow';
        }

        this.eval.target = data;
        this.detail.detailLoad = 1;

      } else if (status == 401) {
        let dialogRef = this.dialog.open(GlobalDialogComponent, {

          data: { message: '등록된 평가 컨텐츠가 존재하지 않습니다.' },

        })

        this.router.navigate(['home']);
      }
    })
  }
  changeDetailPicIndex(index: number) {
    this.detail.picIndex = index;
  }

}
