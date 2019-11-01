import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog, MatDatepicker } from '@angular/material'
import { AddArtistDialogComponent } from '../dialog/add-artist-dialog/add-artist-dialog.component';
import { Moment } from 'moment';
import * as moment from 'moment';
import { WorksSerivceService } from '../works-serivce.service';
import { RESULT } from 'src/const/publicConst';
import { Router, ActivatedRoute } from '@angular/router';
import { ArtistService } from 'src/app/artist/artist.service';
import { WorksNameIsExistDialogComponent } from '../dialog/works-name-is-exist-dialog/works-name-is-exist-dialog.component';
declare const $: any;

@Component({
  selector: 'app-add-works',
  templateUrl: './add-works.component.html',
  styleUrls: ['./add-works.component.css']
})
export class AddWorksComponent implements OnInit {


  work = {
    subject: new FormControl("", [
      Validators.required
    ]),
    type1: new FormControl("", [
      Validators.required
    ]),
    type2: new FormControl("", [
      Validators.required
    ]),
    fileList: [],
    artistList: [],
    create_date: new FormControl("", [
      Validators.required
    ]),
    create_end_date: new FormControl("", [
    ]),
    is_series: false,

  };

  typeList = {
    data: [],
    type2: []
  }

  /**work subject is exist
   * when subject input changed, select subject name and check subjectIsExist
   * 0: is not exist
   * 1: is exist 
   * 2: exist but i want continue 
   */
  subjectIsExist: number = 0;
  /**subject is exist list */
  subjectCheckList: any[];
  /**subject is exist list page data*/
  subjectPageData = {
    totalSize: 0,
    pageNum: 1,
  }

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private workService: WorksSerivceService,
    private route: ActivatedRoute,
    private artistService: ArtistService
  ) { }

  ngOnInit() {

    this.getAllType();
    console.log(this.route.params);
    this.route.params.subscribe(x => {

      if (x.id != null) {

        let data = {};
        data['id'] = x.id;

        this.selectArtistOneInitialize(data);

      }
    })

  }

  fileUpload(fileList: FileList): void {
    for (var i = 0; i < fileList.length; i++) {

      if (this.work.fileList.length == 4) {
        alert("저작물 이미지는 최대 4개를 초과할 수 없습니다");
        return;
      }

      let file: File = fileList[i];
      let size = Math.round(file.size / 1024);
      if (size > 5000) {
        alert("5MB가 넘어가는 이미지는 업로드 하실 수 없습니다.");
        return;
      }
      let pushData = {};
      pushData['file'] = file;
      this.work.fileList.push(pushData);
      const targetIndex = this.work.fileList.length - 1;
      this.fileReader(file, targetIndex);
    }
  }

  fileReader(file: File, i: number) {
    let reader: FileReader = new FileReader();
    reader.onload = (evt) => {
      this.work.fileList[i]['tempData'] = evt.target['result'];
      $("#imgWork").addClass("imgHeight");
      if (this.work.fileList.length >= 3) {
        $("#imgWork").addClass("plus");
      }
    }
    reader.readAsDataURL(file);

  }

  deleteWorkImg(i: number) {
    if (confirm("해당 저작물 이미지를 삭제하시겠습니까?") == false) {
      return;
    }

    this.work.fileList.splice(i, 1);
    if (this.work.fileList.length == 0) {
      $("#imgWork").removeClass("imgHeight");
    }
    if (this.work.fileList.length < 3) {
      $("#imgWork").removeClass("plus");
    }
  }

  searchArtist() {
    const artistList: any[] = Object.assign([], this.work.artistList);
    let dialogRef = this.dialog.open(AddArtistDialogComponent, {

      data: { list: artistList },
      width: "80%"

    })

    dialogRef.afterClosed().subscribe((result) => {
      if (result == undefined || result == null) {
        return;
      }

      this.work.artistList = result;

    })

  }

  check_work_date() {

    if (this.work.is_series == false || this.work.create_end_date.value == undefined) {
      return;
    }

    let create_date = this.work.create_date.value['_d'];
    let end_date = this.work.create_end_date.value['_d'];

    let create_unix = moment(create_date).unix();
    let end_unix = moment(end_date).unix();

    let error = this.work.create_end_date.errors;
    if (error == null) {
      error = { 'biggerThan_create': true };
    } else {
      error['biggerThan_create'] = true;
    }

    if (create_unix > end_unix) {
      this.work.create_end_date.setErrors(error);
    } else {
      if (this.work.create_end_date.errors == null) {
        return;
      }
      delete this.work.create_end_date.errors['biggerThan_create'];
    }

  }

  /*************모든 타입 불러오기********** */
  getAllType() {

    this.workService.getAllWorkType().subscribe((result) => {
      this.typeList.data = Object.assign([], result);
      // console.log(typeList);
    });

  }

  /********* tpye1 값 바뀌었을 때 type2 값 바꾸기********* */
  type1Select(id: number) {

    if (id == undefined) {
      return;
    }

    for (let type1 of this.typeList.data) {
      if (type1.type1_id == id) {
        this.typeList.type2 = Object.assign([], type1['type2Dto']);
      }

    }

  }


  /***저작물 저장*** */
  worksSave() {

    let f = new FormData();

    if (this.subjectIsExist == 1) {
      alert("저작물 이름을 한번 체크해주세요");
    }

    for (let key in this.work) {


      //formData
      if (
        key == "subject" ||
        key == "type1" ||
        key == "type2" ||
        key == "create_date" ||
        key == "create_end_date"
      ) {
        //검사
        if (this.work[key].errors != null) {
          if (key == "create_end_date" && this.work.is_series == true) {
            return;
          } else {
            return;
          }
        }
        //시간은 moment로 포맷해서 보냄
        if (key == "create_date" || key == "create_end_date") {
          let data: any = moment(this.work[key]['value']).unix();
          f.append(key, data);
          continue;
        }


        f.append(key, this.work[key]['value']);
        continue;


      }

      //파일 리스트
      if (key == "fileList") {

        if (this.work[key].length > 4) {
          return;
        }

        for (let file of this.work[key]) {
          let data = file['file'];
          let fileName = file['file']['name'];
          f.append(key, data, fileName);
        }
      }
      //artistList OR OtherArray
      else if (key == "artistList") {
        f.append(key, JSON.stringify(this.work[key]));
      }
      //나머지 다른 폼 데이터
      else {
        f.append(key, this.work[key]);
      }

    }

    this.workService.worksSave(f).subscribe(x => {
      if (x.status == 200) {
        let data = x.body;

        if (data[RESULT.RESULT_KEY] == 201) {
          let message = data[RESULT.MESSAGE_KEY];

          let code = RESULT.GET_MASSAGE_CODE(message);
          if (code == RESULT.WORKS_SAVE_CODE.ARTIST_NOT_EXIST) {
            //this.router.navigate([""])
          }
        }
        this.router.navigate(['/works/worksSaveCheck', data[RESULT.ID_KEY]])
      }
    });


  }

  /**저작자 정보 불러옴 */
  selectArtistOneInitialize(data: any) {
    return this.artistService.selectArtistOne(data).subscribe(x => {
      if (x['result'] == 202) {
        let artist = x['data']['artistDto'];
        this.work.artistList.push(artist);
      }
    });
  }

  /** select work list fot if subject is exist */
  worksSelectListExist() {
    let subject = this.work.subject.value;
    if (subject == "" || subject == null) {
      return;
    }
    let data = { 'searchText': subject, 'pageNum': 1 };
    return this.workService.worksSelectList(data)
      .subscribe(x => {
        this.subjectPageData.totalSize = x['totalSize'];
        this.subjectCheckList = x['data'];
        if (this.subjectCheckList.length > 0) {
          this.subjectIsExist = 1;
        } else {
          this.subjectIsExist = 0;
        }
      })
  }
  /**show the check subject dialog*/
  checkWorkSubject() {
    let dialogRef = this.dialog.open(WorksNameIsExistDialogComponent, {

      data: {
        list: this.subjectCheckList,
        subject: this.work.subject.value,
        page: this.subjectPageData,
      },
      width: "80%"

    })

    dialogRef.afterClosed().subscribe((result) => {
      if (result == undefined || result == null) {
        return;
      }

      if (result == 1) {
        this.subjectIsExist = 2;
      }

    })
  }

}
