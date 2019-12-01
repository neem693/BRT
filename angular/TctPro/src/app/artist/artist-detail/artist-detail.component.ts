import { Component, OnInit, Input } from '@angular/core';
import { WorksSerivceService } from 'src/app/works/works-serivce.service';
import { Router, ActivatedRoute } from '@angular/router';
import { RESULT } from 'src/const/publicConst';
import { environment } from 'src/environments/environment';

declare const $:any;

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.css']
})
export class ArtistDetailComponent implements OnInit {

  @Input() artist_id:number = -1;
  /**
   * screen move
   */
  @Input() index:number = -1;
  /**
   * included add-artist-dialong => -1
   */
  @Input() autoLoading:number=-1;

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
        
        if(x['id'] == undefined || x['id'] == null){
          return;
        }

        let id = Number(x['id']);
        
        this.selectWorksByArtistOnes(id);
      }
    })

    // console.log(this.artist_id);
    // console.log(this.autoLoading);
    // console.log(this.index);
    if(this.artist_id != -1){
      
      this.selectWorksByArtistOnes(this.artist_id);

    }
    

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
      this.doIfIncluded();
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
      this.doIfIncluded();
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
      this.doIfIncluded();
    });
  }


/**
 * if included this artist-detail component(ex:artist add dialog)
 * 
 */
  doIfIncluded(){

    if(this.autoLoading == 1){
      setTimeout(() => {
        let currentScroll: number = $(".artist_search_list").eq(0).scrollTop();
        let top: number = currentScroll + $("#w_" + this.index).offset().top;
        let diff: number = $(".artist_search_list").offset().top;
        $("#artist_search_list").animate({ scrollTop: top - diff - 50 }, 500, () => {
          // console.log($("#artist_search_list").scrollTop());
          // console.log($("#w_" + index).offset().top);
        });
      }, 200);
    }
  
  }

/**
 * go to the works detail page
 */
  goToWorksDetail(id:number){

    this.router.navigate(["/works/search",id]);

  }


}
