import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { WorksAddComponent } from '../dialog/works-add/works-add-diaolog.component';
import { ArtistService } from '../artist.service';
import { ActivatedRoute, Router } from '@angular/router';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { RESULT } from 'src/const/publicConst';
import { ArtNameIsExistDialogComponent } from '../dialog/art-name-is-exist-dialog/art-name-is-exist-dialog.component';

@Component({
  selector: 'app-artist-add',
  templateUrl: './artist-add.component.html',
  styleUrls: ['./artist-add.component.css']
})
export class ArtistAddComponent implements OnInit {

  artist = {
    artist_name: new FormControl("", [
      Validators.required
    ]),
    work_list: [],
  }

    /**artist name is exist
   * when artist input changed, select artist name and check artistIsExist
   * 0: is not exist
   * 1: is exist 
   * 2: exist but i want continue 
   */
  artistIsExist: number = 0;
  /**
   * artistPageData is exist list page data
   */
  artistPageData = {
    list:[],
    totalSize:0,
    pageNum: 1
  }

  constructor(
    private dialog: MatDialog,
    private artistService: ArtistService,
    private router: Router,
    private route: ActivatedRoute,
    private worksService:WorksSerivceService
  ) { }

  ngOnInit() {

    this.route.params.subscribe(x => {
      let data = {};
      data['id'] = x.id;
      this.worksSelectOneInitialize(data);
    })

  }

  addWorks() {

    let worksList = Object.assign([], this.artist.work_list);
    let dialogRef = this.dialog.open(WorksAddComponent, {

      data: { list: worksList },
      width: "80%"

    })

    dialogRef.afterClosed().subscribe((result) => {
      if (result == undefined || result == null) {
        return;
      }

      this.artist.work_list = result;

    })
  }

  artistSave() {
    // console.log(this.artist);
    if(this.artistIsExist == 1){
      alert("저작자 이름을 체크해주세요.");
      return;
    }

    let artist_name_error = this.artist.artist_name.errors;
    if (artist_name_error != null) {
      return;
    }

    let data = {};
    data['artist_name'] = this.artist.artist_name.value;
    data['worksList'] = this.artist.work_list;

    this.artistService.artistSave(data).subscribe(x => {
      let data = x.body;
      let code = Number(data['result']);

      if (code == 200) {
        
        let id = data['id'];
        this.router.navigate(['/artist/artistSaveCheck', id]);

      } else if (code == 201) {

        let id = data['id'];
        this.router.navigate(['/artist/artistSaveCheck', id]);

      }
    });

  }

  worksSelectOneInitialize(data: any) {

    this.worksService.worksSelectOne(data).subscribe(x => {

      let code = x['result'];

      if (code == 202) {
        let data = x['data'];
        this.artist.work_list.push(data);
      }

    })

  }

  artistSelectListExist(){
    
    let artist_name = this.artist.artist_name.value;
    let data = {
      'searchText':artist_name,
      'pageNum':1
    };

    this.artistService.selectArtistList(data).subscribe(x=>{
      let size = x[RESULT.TOTALSIZE_KEY];
      if(size > 0){
        this.artistIsExist = 1;

        this.artistPageData.list = x[RESULT.DATA_KEY];
        this.artistPageData.pageNum = 1;
        this.artistPageData.totalSize = size;

      }

      
      
    })

  }

  checkartistName(){

    let data ={
      'list': this.artistPageData.list,
      'totalSize' : this.artistPageData.totalSize,
      'pageNum':this.artistPageData.pageNum,
      'searchText':this.artist.artist_name.value,
    }

    let dialogRef = this.dialog.open(ArtNameIsExistDialogComponent,{
      data:data,
      width:"80%"
    });

    dialogRef.afterClosed().subscribe(result=>{
      if(result == undefined || result == null){
        return;
      }
      if(result == 1){
        this.artistIsExist =2;
      }
    })
    

  }

}
