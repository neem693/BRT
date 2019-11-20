import { Component, OnInit } from '@angular/core';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { Router, ActivatedRoute } from '@angular/router';
import { RESULT } from 'src/const/publicConst';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.css']
})
export class ArtistDetailComponent implements OnInit {

  loading = {
    firstLoading:1,
    SeeLoading:0,
    ListenLoading:0,
    DooLoading:0,
  }

  works = {
    see:[],
    listen:[],
    doo:[]
  }

  page = {
    see: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 3,
    },
    listen: {
      totalSize: 0,
      pageNum: 1,
      pageSize: 10
    },
    doo:{
      totalSize: 0,
      pageNum: 1,
      pageSize: 10
    }
  }

  artist = {};

  dir = {
    image: environment.imageBaseUrl
  }

  constructor(
    private worksService:WorksSerivceService,
    private router:Router,
    private route:ActivatedRoute
    ) { }

  ngOnInit() {

    this.route.params.subscribe(x=>{
      if(this.loading.firstLoading == 1){
        let id = Number(x['id']);
        
        this.selectWorksByArtistOnes(id);
      }
    })

    

  }

  selectWorksByArtistOnes(id:number){
    let data = {};
    data['id'] = id;
    this.worksService.selectWorksByArtistOnes(data).subscribe(x=>{
      this.loading.firstLoading = 0;
      let result = x[RESULT.RESULT_KEY];
      let data = x[RESULT.DATA_KEY];
      this.works.see = data['see'];
      this.works.listen = data['listen'];
      this.works.doo = data['doo'];

      this.page.see.totalSize = data['seeCount'];
      this.page.listen.totalSize = data['listenCount'];
      this.page.doo.totalSize = data['dooCount'];
      this.artist = data['artist'];
    });
  }

  selectSeePage(page:number){
    let param = {};
    // console.log(this.artist);
    param['id'] = this.artist['artist_id'];
    param['pageNum'] = page;
    param['type1'] = 1;

    console.log(param);
    this.loading.SeeLoading =1;
    this.worksService.selectSeePage(param).subscribe(x=>{
      setTimeout(()=>{
        this.loading.SeeLoading =0;
      },500)
      let result = x[RESULT.RESULT_KEY];
      let data = x[RESULT.DATA_KEY];
      let totalSize = x[RESULT.TOTALSIZE_KEY];
      this.works.see = data;
      this.page.see.totalSize = totalSize;
    });

  }
  selectListenPage(page:number){

    let param = {};
    // console.log(this.artist);
    param['id'] = this.artist['artist_id'];
    param['pageNum'] = page;
    param['type1'] = 2;

    this.loading.ListenLoading =1;
    this.worksService.selectSeePage(param).subscribe(x=>{
      setTimeout(()=>{
        this.loading.ListenLoading =0;
      },500)
      let result = x[RESULT.RESULT_KEY];
      let data = x[RESULT.DATA_KEY];
      let totalSize = x[RESULT.TOTALSIZE_KEY];
      this.works.listen = data;
      this.page.listen.totalSize = totalSize;
    });
  }
  selectDooPage(page:number){
    let param = {};
    // console.log(this.artist);
    param['id'] = this.artist['artist_id'];
    param['pageNum'] = page;
    param['type1'] = 3;

    this.loading.ListenLoading =1;
    this.worksService.selectSeePage(param).subscribe(x=>{
      setTimeout(()=>{
        this.loading.ListenLoading =0;
      },500)
      let result = x[RESULT.RESULT_KEY];
      let data = x[RESULT.DATA_KEY];
      let totalSize = x[RESULT.TOTALSIZE_KEY];
      this.works.doo = data;
      this.page.doo.totalSize = totalSize;
    });
  }


}
